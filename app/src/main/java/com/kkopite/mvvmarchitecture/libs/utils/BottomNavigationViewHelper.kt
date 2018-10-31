package com.kkopite.mvvmarchitecture.libs.utils

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.design.internal.BottomNavigationItemView

/**
 * http://stackoverflow.com/questions/40176244/how-to-disable-bottomnavigationview-shift-mode
 */
@SuppressLint("RestrictedApi")
fun BottomNavigationView.disableShiftMode() {
    val view = getChildAt(0) as BottomNavigationMenuView
    val shiftingMode = view.javaClass.getDeclaredField("mShiftingMode")
    shiftingMode.isAccessible = true
    shiftingMode.setBoolean(view, false)
    shiftingMode.isAccessible = false
    for (i in 0 until view.childCount) {
        val item = view.getChildAt(i) as BottomNavigationItemView

        item.setShiftingMode(false)
        // set once again checked value, so view will be updated

        item.setChecked(item.itemData.isChecked)
    }
}