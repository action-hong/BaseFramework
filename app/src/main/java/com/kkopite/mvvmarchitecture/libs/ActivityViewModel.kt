package com.kkopite.mvvmarchitecture.libs

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import com.kkopite.mvvmarchitecture.IApplication
import com.kkopite.mvvmarchitecture.ui.data.ActivityResult
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.android.RxLifecycleAndroid
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import timber.log.Timber

/**
 * Created by kkopite on 2018/9/27.
 */
open class ActivityViewModel(application: Application) : AndroidViewModel(application), LifecycleProvider<ActivityEvent> {

    private val mLifecycleSubject: BehaviorSubject<ActivityEvent> = BehaviorSubject.create()

    // 貌似无用了
    private val mActivityResult: PublishSubject<ActivityResult> = PublishSubject.create()

    private val mIntent: PublishSubject<Intent> = PublishSubject.create()

    private var mEnvironment: Environment = (application as IApplication).component().environment()

    fun activityResult(activityResult: ActivityResult) {
        mActivityResult.onNext(activityResult)
    }

    fun intent(intent: Intent?) {
        if (intent != null) {
            mIntent.onNext(intent)
        }
    }

    @CallSuper
    open fun onCreate(context: Context, savedInstanceState: Bundle?) {
        Timber.d("onCreate %s", this.toString())
        mLifecycleSubject.onNext(ActivityEvent.CREATE)
    }

    @CallSuper
    open fun onResume() {
        Timber.d("onResume %s", this.toString())
        mLifecycleSubject.onNext(ActivityEvent.RESUME)
    }

    @CallSuper
    open fun onPause() {
        Timber.d("onPause %s", this.toString())
        mLifecycleSubject.onNext(ActivityEvent.PAUSE)
    }

    @CallSuper
    open fun onDestroy() {
        Timber.d("onDestroy %s", this.toString())
        mLifecycleSubject.onNext(ActivityEvent.DESTROY)
    }

    @CallSuper
    open fun onStart() {
        mLifecycleSubject.onNext(ActivityEvent.START)
    }

    @CallSuper
    open fun onStop() {
        mLifecycleSubject.onNext(ActivityEvent.STOP)
    }
    protected fun activityResult(): Observable<ActivityResult> {
        return this.mActivityResult
    }

    protected fun intent(): Observable<Intent> {
        return this.mIntent
    }

    override fun <T : Any?> bindToLifecycle(): LifecycleTransformer<T> {
        return RxLifecycleAndroid.bindActivity(mLifecycleSubject)
    }

    override fun lifecycle(): Observable<ActivityEvent> {
        return mLifecycleSubject.hide()
    }

    override fun <T : Any?> bindUntilEvent(event: ActivityEvent): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(mLifecycleSubject, event)
    }

}