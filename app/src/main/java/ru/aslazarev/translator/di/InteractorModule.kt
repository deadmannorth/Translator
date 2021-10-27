package ru.aslazarev.translator.di

import dagger.Module
import dagger.Provides
import ru.aslazarev.translator.Repository
import ru.aslazarev.translator.interactor.main.MainInteractor
import ru.aslazarev.translator.model.DataModel
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    fun provideInteractor(
        @Named(NAME_REMOTE) remoteRepo: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) localRepo: Repository<List<DataModel>>,
    ): MainInteractor {
        return MainInteractor(remoteRepo, localRepo)
    }
}