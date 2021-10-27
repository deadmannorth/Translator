package ru.aslazarev.translator.di

import dagger.Module
import dagger.Provides
import ru.aslazarev.translator.DataSource
import ru.aslazarev.translator.Repository
import ru.aslazarev.translator.model.DataModel
import ru.aslazarev.translator.model.remote.RemoteData
import ru.aslazarev.translator.model.remote.RepoImpl
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    fun provideRemoteRepo(@Named(NAME_REMOTE) dataSource: DataSource<List<DataModel>>): Repository<List<DataModel>> {
        return RepoImpl(dataSource)
    }

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    fun provideLocalRepo(@Named(NAME_LOCAL) dataSource: DataSource<List<DataModel>>): Repository<List<DataModel>> {
        return RepoImpl(dataSource)
    }

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRemoteDataSource(): DataSource<List<DataModel>> {
        return RemoteData()
    }

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideLocalDataSource(): DataSource<List<DataModel>> {
        return RemoteData() // todo
    }

}