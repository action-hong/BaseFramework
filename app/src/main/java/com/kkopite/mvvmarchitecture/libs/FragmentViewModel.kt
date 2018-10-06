package com.kkopite.mvvmarchitecture.libs

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.os.Bundle
import android.support.annotation.CallSuper
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kkopite.mvvmarchitecture.IApplication
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.android.RxLifecycleAndroid
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import timber.log.Timber

/**
 * Created by kkopite on 2018/9/27.
 */
public open class FragmentViewModel(application: Application) : AndroidViewModel(application), LifecycleProvider<FragmentEvent> {

    private var mEnvironment: Environment = (application as IApplication).component().environment()

    override fun <T : Any?> bindToLifecycle(): LifecycleTransformer<T> {
        return RxLifecycleAndroid.bindFragment(mLifecycleSubject)
    }

    override fun lifecycle(): Observable<FragmentEvent> {
        return mLifecycleSubject.hide()
    }

    override fun <T : Any?> bindUntilEvent(event: FragmentEvent): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(mLifecycleSubject, event)
    }

    private val mLifecycleSubject: BehaviorSubject<FragmentEvent> = BehaviorSubject.create()

    private val arguments: PublishSubject<Bundle> = PublishSubject.create()

    @CallSuper
    fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate %s", this.toString())
        mLifecycleSubject.onNext(FragmentEvent.CREATE)
    }

    /**
     * Takes bundle arguments from the view.
     */
    public fun arguments(bundle: Bundle?) {
        if (bundle != null) {
            this.arguments.onNext(bundle)
        }
    }

    fun getArguments(): Observable<Bundle> {
        return this.arguments
    }

    @CallSuper
    fun onResume() {
        Timber.d("onResume %s", this.toString())
        mLifecycleSubject.onNext(FragmentEvent.RESUME)
    }

    @CallSuper
    fun onPause() {
        Timber.d("onPause %s", this.toString())
        mLifecycleSubject.onNext(FragmentEvent.RESUME)
    }

    @CallSuper
    fun onDestroy() {
        Timber.d("onDestroy %s", this.toString())
        mLifecycleSubject.onNext(FragmentEvent.RESUME)
    }

    @CallSuper
    fun onDetach() {
        Timber.d("onDetach %s", this.toString())
        mLifecycleSubject.onNext(FragmentEvent.DETACH)
    }

    @CallSuper
    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) {
        mLifecycleSubject.onNext(FragmentEvent.CREATE_VIEW)
    }

    @CallSuper
    fun onStart() {
        mLifecycleSubject.onNext(FragmentEvent.START)
    }

    @CallSuper
    fun onStop() {
        mLifecycleSubject.onNext(FragmentEvent.STOP)
    }

    @CallSuper
    fun onDestroyView() {
        mLifecycleSubject.onNext(FragmentEvent.DESTROY_VIEW)
    }

}