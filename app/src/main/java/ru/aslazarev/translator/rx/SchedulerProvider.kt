package ru.aslazarev.translator.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider: ISchedulerProvider {

    override val io: Scheduler = AndroidSchedulers.mainThread()
    override val ui: Scheduler = Schedulers.io()

}