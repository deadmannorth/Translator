package ru.aslazarev.translator.view.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import ru.aslazarev.translator.model.AppState

open class BaseViewModel <T: AppState>(
    protected val stateLiveData: MutableLiveData<T> = MutableLiveData(),
        ) : ViewModel() {

    protected val viewModelScope = CoroutineScope(
        Dispatchers.Main + SupervisorJob()
    )

    protected val state = SavedStateHandle()

    open fun getStateLiveData(): LiveData<T> = stateLiveData

    override fun onCleared() {
        viewModelScope.cancel()
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