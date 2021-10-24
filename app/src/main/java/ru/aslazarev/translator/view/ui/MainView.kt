package ru.aslazarev.translator.view.ui

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.aslazarev.translator.model.AppState

@AddToEndSingle
interface MainView: MvpView {
    fun renderData(appState: AppState)
}