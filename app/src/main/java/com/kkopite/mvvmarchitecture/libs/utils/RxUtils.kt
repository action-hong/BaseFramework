package com.kkopite.mvvmarchitecture.libs.utils

import com.kkopite.mvvmarchitecture.core.bean.BaseResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.lang.Exception

fun <T> Observable<T>.execIOThenObserveOnMain(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.execIOThenObserveOnMain(): Flowable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<BaseResponse<T>>.handleResult(): Observable<T> {
    return map {
        Timber.d(it.toString())
        if (it.errorCode == 0 && it.data != null) {
            return@map it.data
        }
        // 抛出异常
        throw Exception(it.errorMsg)
    }
}


