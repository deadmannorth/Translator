package ru.aslazarev.translator.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.aslazarev.translator.model.AppState

abstract class BaseActivity<T: AppState>: AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model.getStateLiveData().observe(this) {renderData(it)}
    }

    abstract fun renderData(appState: T)

}