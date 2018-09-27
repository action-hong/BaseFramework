package com.kkopite.mvvmarchitecture.libs

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
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
public open class ActivityViewModel(application: Application, environment: Environment) : AndroidViewModel(application), LifecycleProvider<ActivityEvent> {

    private val mLifecycleSubject: BehaviorSubject<ActivityEvent> = BehaviorSubject.create()

    // 貌似无用了
    private val mActivityResult: PublishSubject<ActivityResult> = PublishSubject.create()

    private val mIntent: PublishSubject<Intent> = PublishSubject.create()

    public fun activityResult(activityResult: ActivityResult) {
        mActivityResult.onNext(activityResult)
    }

    public fun intent(intent: Intent?) {
        if (intent != null) {
            mIntent.onNext(intent)
        }
    }

    @CallSuper
    fun onCreate(context: Context, savedInstanceState: Bundle?) {
        Timber.d("onCreate %s", this.toString())
        mLifecycleSubject.onNext(ActivityEvent.CREATE)
    }

    @CallSuper
    protected fun onResume() {
        Timber.d("onResume %s", this.toString())
        mLifecycleSubject.onNext(ActivityEvent.RESUME)
    }

    @CallSuper
    protected fun onPause() {
        Timber.d("onPause %s", this.toString())
        mLifecycleSubject.onNext(ActivityEvent.PAUSE)
    }

    @CallSuper
    fun onDestroy() {
        Timber.d("onDestroy %s", this.toString())
        mLifecycleSubject.onNext(ActivityEvent.DESTROY)
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