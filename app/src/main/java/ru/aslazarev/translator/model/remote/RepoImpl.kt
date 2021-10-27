package ru.aslazarev.translator.model.remote

import io.reactivex.Observable
import ru.aslazarev.translator.DataSource
import ru.aslazarev.translator.Repository
import ru.aslazarev.translator.model.DataModel

class RepoImpl(
    private val dataSource: DataSource<List<DataModel>>
): Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }

}