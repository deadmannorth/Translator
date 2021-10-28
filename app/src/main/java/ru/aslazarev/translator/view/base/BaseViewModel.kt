package ru.aslazarev.translator.view.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
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

    protected val state = SavedStateHandle()

    open fun getStateLiveData(): LiveData<T> = stateLiveData

    override fun onCleared() {
        compositeDisposable.clear()
    }

    open fun saveState(){
        state.set("LIVE_DATA", stateLiveData.value)
        Log.d("LIVE_DATA", "${stateLiveData.value}")
    }

    open fun loadState(){
        state.getLiveData("LIVE_DATA", stateLiveData.value)
        Log.d("LIVE_DATA", "${stateLiveData.value}")
    }
}