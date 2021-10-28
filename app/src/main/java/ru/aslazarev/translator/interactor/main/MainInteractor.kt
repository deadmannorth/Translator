package ru.aslazarev.translator.interactor.main

import io.reactivex.Observable
import ru.aslazarev.translator.Interactor
import ru.aslazarev.translator.Repository
import ru.aslazarev.translator.model.AppState
import ru.aslazarev.translator.model.DataModel

class MainInteractor (
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
): Interactor<AppState> {

    override fun getData(word: String, isRemoteSource: Boolean): Observable<AppState> {
        return if (isRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}