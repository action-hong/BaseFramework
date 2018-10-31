package com.kkopite.mvvmarchitecture.libs.extension

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

inline fun FragmentManager.fgTransaction (func : FragmentTransaction.() -> Unit) {
    val transaction = beginTransaction()
    func(transaction)
    transaction.commitAllowingStateLoss()
}