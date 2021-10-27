package ru.aslazarev.translator.model.remote

import io.reactivex.Observable
import ru.aslazarev.translator.DataSource
import ru.aslazarev.translator.model.DataModel
import ru.aslazarev.translator.remote.Api


class RemoteData: DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        return Api().dataSource.search(word)
    }
}