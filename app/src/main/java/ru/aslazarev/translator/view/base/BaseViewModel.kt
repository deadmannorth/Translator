package ru.aslazarev.translator.view.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.aslazarev.translator.model.AppState
import ru.aslazarev.translator.rx.ISchedulerProvider
import ru.aslazarev.translator.rx.SchedulerProvider

open class BaseViewModel <T: AppState>(
    protected val stateLiveData: MutableLiveData<T> = MutableLiveData(),
    val schedulerProvider: ISchedulerProvider = SchedulerProvider()
        ) : ViewModel() {

        protected val compositeDisposable = CompositeDisposable()

        open fun getStateLiveData(): LiveData<T> = stateLiveData

    override fun onCleared() {
        compositeDisposable.clear()
    }
}