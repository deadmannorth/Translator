package ru.aslazarev.translator

import io.reactivex.Observable
import ru.aslazarev.translator.model.AppState

interface View {
    fun renderData(appState: AppState)
}

interface Interactor<T> {
    fun getData(word: String, isRemoteSource: Boolean): Observable<T>
}

interface Repository<T> {

    fun getData(word: String): Observable<T>
}

interface DataSource<T> {

    fun getData(word: String): Observable<T>
}