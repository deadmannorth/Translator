package ru.aslazarev.translator.presentation

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter
import ru.aslazarev.translator.model.AppState
import ru.aslazarev.translator.model.DataModel
import ru.aslazarev.translator.model.remote.RemoteData
import ru.aslazarev.translator.view.ui.MainView

class MainPresenter: MvpPresenter<MainView>() {

    private val compositeDisposable = CompositeDisposable()
    private val repo = RemoteData()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun getData(word: String){
        compositeDisposable.add(
            repo.getData(word)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.renderData(AppState.Loading(null)) }
            .subscribe ({
                        viewState?.renderData(AppState.Success(it))},
                {viewState.renderData(AppState.Error(it))}))

    }
}