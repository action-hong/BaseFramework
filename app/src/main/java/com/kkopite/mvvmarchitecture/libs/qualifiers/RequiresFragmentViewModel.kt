package com.kkopite.mvvmarchitecture.libs.qualifiers

import com.kkopite.mvvmarchitecture.libs.FragmentViewModel
import java.lang.annotation.Inherited
import kotlin.reflect.KClass

/**
 * Created by kkopite on 2018/10/6.
 */
@Inherited
@Retention(AnnotationRetention.RUNTIME)
annotation class RequiresFragmentViewModel(val value: KClass<out FragmentViewModel>)