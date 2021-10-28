package ru.aslazarev.translator

import io.reactivex.Observable
import ru.aslazarev.translator.model.AppState

interface View {
    fun renderData(appState: AppState)
}

interface Interactor<T> {
    suspend fun getData(word: String, isRemoteSource: Boolean): T
}

interface Repository<T> {

    suspend fun getData(word: String): T
}

interface DataSource<T> {

    suspend fun getData(word: String): T
}