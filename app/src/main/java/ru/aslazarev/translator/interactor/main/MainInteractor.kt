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

    override suspend fun getData(word: String, isRemoteSource: Boolean): AppState {
        return if (isRemoteSource) {
            val data = remoteRepository.getData(word)
            AppState.Success(data)
        } else {
            val data = localRepository.getData(word)
            AppState.Success(data)
        }
    }
}