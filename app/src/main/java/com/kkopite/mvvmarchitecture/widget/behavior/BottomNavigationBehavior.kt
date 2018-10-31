package com.kkopite.mvvmarchitecture.widget.behavior

import android.opengl.ETC1.getHeight
import android.support.v4.view.ViewCompat.getTranslationY
import clojure.lang.LockingTransaction.isRunning
import android.animation.ObjectAnimator
import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View


class BottomNavigationBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {

    private var outAnimator: ObjectAnimator? = null
    private var inAnimator: ObjectAnimator? = null

    // 垂直滑动
    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, nestedScrollAxes: Int): Boolean {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dx: Int, dy: Int, consumed: IntArray) {
        if (dy > 0) {// 上滑隐藏
            if (outAnimator == null) {
                outAnimator = ObjectAnimator.ofFloat(child, "translationY", 0f, child.height.toFloat())
                outAnimator!!.duration = 200
            }
            if (!outAnimator!!.isRunning && child.getTranslationY() <= 0) {
                outAnimator!!.start()
            }
        } else if (dy < 0) {// 下滑显示
            if (inAnimator == null) {
                inAnimator = ObjectAnimator.ofFloat(child, "translationY", child.height.toFloat(), 0f)
                inAnimator!!.duration = 200
            }
            if (!inAnimator!!.isRunning && child.translationY >= child.height) {
                inAnimator!!.start()
            }
        }
    }
}