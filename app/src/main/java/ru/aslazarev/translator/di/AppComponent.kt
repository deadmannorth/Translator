package ru.aslazarev.translator.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ru.aslazarev.translator.TranslatorApp
import javax.inject.Singleton

@Component(
    modules = [
        InteractorModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        RepoModule::class,
        AndroidInjectionModule::class,
    ]
)
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: TranslatorApp)
}