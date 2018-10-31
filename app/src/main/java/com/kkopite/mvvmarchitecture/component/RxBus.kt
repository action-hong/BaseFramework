package com.kkopite.mvvmarchitecture.component

import io.reactivex.processors.PublishProcessor
import io.reactivex.Flowable



object RxBus {

    private val bus = PublishProcessor.create<Any>().toSerialized()

    fun post (o: Any) {
        bus.onNext(o)
    }

    fun <T> toFlowable(eventType: Class<T>): Flowable<T> {
        return bus.ofType(eventType)
    }

}