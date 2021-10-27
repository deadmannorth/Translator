package ru.aslazarev.translator.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


sealed interface AppState {
    @Parcelize
    data class Success(val data: List<DataModel>): AppState, Parcelable
    @Parcelize
    data class Error(val t: Throwable): AppState, Parcelable
    @Parcelize
    data class Loading(val progress: Int? = null): AppState, Parcelable
}