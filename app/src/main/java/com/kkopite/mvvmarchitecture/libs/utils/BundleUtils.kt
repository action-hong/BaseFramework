package com.kkopite.mvvmarchitecture.libs.utils

import android.os.Bundle

/**
 * Created by kkopite on 2018/9/27.
 */
public class BundleUtils {

    companion object {
        internal fun maybeGetBundle(savedInstanceState: Bundle?, key: String): Bundle? {
            return savedInstanceState?.getBundle(key)
        }
    }
}