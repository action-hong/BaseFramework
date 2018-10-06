package com.kkopite.mvvmarchitecture

import dagger.Component
import javax.inject.Singleton


/**
 * Created by kkopite on 2018/9/27.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent : ApplicationGraph