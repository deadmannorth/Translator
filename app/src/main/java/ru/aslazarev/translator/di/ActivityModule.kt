package ru.aslazarev.translator.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.aslazarev.translator.view.ui.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}