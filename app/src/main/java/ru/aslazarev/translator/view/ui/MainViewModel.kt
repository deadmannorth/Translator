package ru.aslazarev.translator.view.ui

import io.reactivex.observers.DisposableObserver
import kotlinx.coroutines.launch
import ru.aslazarev.translator.interactor.main.MainInteractor
import ru.aslazarev.translator.model.AppState
import ru.aslazarev.translator.view.base.BaseViewModel

class MainViewModel (
    private val interactor: MainInteractor
    ): BaseViewModel<AppState>() {

    fun getWordDescriptions(word: String, isOnline: Boolean) {
        viewModelScope.launch {
            try {
                val data = interactor.getData(word, isOnline)
                stateLiveData.value = data
            } catch (e: Exception){
                stateLiveData.value = AppState.Error(e)
            }
        }
    }

    private fun getObserver() = object : DisposableObserver<AppState>() {
        override fun onNext(appState: AppState) {
            stateLiveData.value = appState
        }

        override fun onError(e: Throwable) {
            stateLiveData.value = AppState.Error(e)
        }

        override fun onComplete() = Unit
    }

    override fun saveState() {
        super.saveState()
    }

    override fun loadState() {
        super.loadState()
    }
}