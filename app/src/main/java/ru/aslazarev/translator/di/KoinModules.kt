package ru.aslazarev.translator.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.aslazarev.translator.Repository
import ru.aslazarev.translator.interactor.main.MainInteractor
import ru.aslazarev.translator.model.DataModel
import ru.aslazarev.translator.model.remote.RemoteData
import ru.aslazarev.translator.model.remote.RepoImpl
import ru.aslazarev.translator.view.ui.MainViewModel

val application = module {
    single<Repository<List<DataModel>>> (named(NAME_REMOTE)){ RepoImpl(RemoteData()) }
    single<Repository<List<DataModel>>> (named(NAME_LOCAL)){ RepoImpl(RemoteData()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}