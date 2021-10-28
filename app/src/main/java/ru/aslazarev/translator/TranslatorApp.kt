package ru.aslazarev.translator

import android.app.Application
import org.koin.core.context.startKoin
import ru.aslazarev.translator.di.application
import ru.aslazarev.translator.di.mainScreen

class TranslatorApp : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(
            listOf(application, mainScreen)
        ) }
    }
}