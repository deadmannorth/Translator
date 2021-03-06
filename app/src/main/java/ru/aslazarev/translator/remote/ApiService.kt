package ru.aslazarev.translator.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ru.aslazarev.translator.model.DataModel

interface ApiService {
    @GET("words/search")
    fun search(@Query("search") word: String): Observable<List<DataModel>>
}