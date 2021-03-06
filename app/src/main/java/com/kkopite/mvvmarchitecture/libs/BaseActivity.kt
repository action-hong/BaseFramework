package com.kkopite.mvvmarchitecture.libs

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.annotation.AnimRes
import android.support.v7.app.AppCompatActivity
import android.util.Pair
import com.kkopite.mvvmarchitecture.ApplicationComponent
import com.kkopite.mvvmarchitecture.IApplication
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresActivityViewModel
import com.kkopite.mvvmarchitecture.ui.data.ActivityResult
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import kotlin.reflect.KClass

/**
 * Created by kkopite on 2018/9/27.
 */
public abstract class BaseActivity<ViewModelType: ActivityViewModel>: AppCompatActivity() {


    private val mBack: PublishSubject<Any> = PublishSubject.create()
    protected lateinit var mViewModel: ViewModelType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val annotation = this.javaClass.getAnnotation(RequiresActivityViewModel::class.java)
        @Suppress("UNCHECKED_CAST")
        val kClass = annotation?.value as KClass<ViewModelType>
        mViewModel = ViewModelProviders.of(this).get(kClass.java)
        mViewModel.onCreate(this, savedInstanceState)
        mViewModel.intent(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mViewModel.activityResult(ActivityResult.create(requestCode, resultCode, data))
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        mViewModel.intent(intent)
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart %s", this.toString())

        mBack.bindUntilEvent(this, Lifecycle.Event.ON_STOP)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { goBack() }
    }

    override fun onStop() {
        super.onStop()
        mViewModel.onStop()
    }

    override fun onResume() {
        super.onResume()
        mViewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        mViewModel.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewModel.onDestroy()
    }

    /**
     * @deprecated Use {@link #back()} instead.
     *
     *             In rare situations, onBackPressed can be triggered after {@link #onSaveInstanceState(Bundle)} has been called.
     *             This causes an {@link IllegalStateException} in the fragment manager's `checkStateLoss` method, because the
     *             UI state has changed after being saved. The sequence of events might look like this:
     *
     *             onSaveInstanceState -> onStop -> onBackPressed
     *
     *             To avoid that situation, we need to ignore calls to `onBackPressed` after the activity has been saved. Since
     *             the activity is stopped after `onSaveInstanceState` is called, we can create an observable of back events,
     *             and a subscription that calls super.onBackPressed() only when the activity has not been stopped.
     */
    override fun onBackPressed() {
        back()
    }

    open fun back() {
        mBack.onNext(1)
    }

    /**
     * Override in subclasses for custom exit transitions. First item in pair is the enter animation,
     * second item in pair is the exit animation.
     */
    protected fun exitTransition(): Pair<Int, Int>? {
        return null
    }

    protected fun startActivityWithTransition(intent: Intent, @AnimRes enterAnim: Int,
                                              @AnimRes exitAnim: Int) {
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
    }

    fun application(): IApplication {
        return application as IApplication
    }

    private fun component(): ApplicationComponent {
        return application().component()
    }

    public fun environment(): Environment {
        return component().environment()
    }

    private fun goBack() {
        super.onBackPressed()

        val exitTransition = exitTransition()
        if (exitTransition != null) {
            overridePendingTransition(exitTransition.first, exitTransition.second)
        }
    }

}