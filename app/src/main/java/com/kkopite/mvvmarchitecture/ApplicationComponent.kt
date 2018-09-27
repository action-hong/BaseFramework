package com.kkopite.mvvmarchitecture

import dagger.Component
import kotlin.reflect.jvm.internal.impl.javax.inject.Singleton

/**
 * Created by kkopite on 2018/9/27.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
public interface ApplicationComponent : ApplicationGraph {

}