package ru.aslazarev.translator.model

sealed interface AppState {
    data class Success(val data: List<DataModel>): AppState
    data class Error(val t: Throwable): AppState
    data class Loading(val progress: Int? = null): AppState
}