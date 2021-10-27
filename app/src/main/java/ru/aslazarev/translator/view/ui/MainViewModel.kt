package ru.aslazarev.translator.view.ui

import io.reactivex.observers.DisposableObserver
import ru.aslazarev.translator.Repository
import ru.aslazarev.translator.interactor.main.MainInteractor
import ru.aslazarev.translator.model.AppState
import ru.aslazarev.translator.model.DataModel
import ru.aslazarev.translator.model.remote.RemoteData
import ru.aslazarev.translator.model.remote.RepoImpl
import ru.aslazarev.translator.view.base.BaseViewModel
import kotlin.concurrent.thread

class MainViewModel (
    private val interactor: MainInteractor = MainInteractor(
        remoteRepository = RepoImpl(RemoteData()),
        localRepository = RepoImpl(RemoteData())
    )
        ): BaseViewModel<AppState>() {

    fun getWordDescriptions(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io)
                .observeOn(schedulerProvider.ui)
                .doOnSubscribe { stateLiveData.value = AppState.Loading(null) }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver() = object : DisposableObserver<AppState>() {
        override fun onNext(appState: AppState) {
            stateLiveData.value = appState
        }

        override fun onError(e: Throwable) {
            stateLiveData.postValue(AppState.Error(e))
        }

        override fun onComplete() = Unit
    }
}