package com.kkopite.mvvmarchitecture

import android.support.multidex.MultiDexApplication
import timber.log.Timber

/**
 * Created by kkopite on 2018/9/27.
 */
public class IApplication: MultiDexApplication() {

    private lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder()
                .build()

        Timber.plant(Timber.DebugTree())
    }

    fun component(): ApplicationComponent {
        return mApplicationComponent
    }

}