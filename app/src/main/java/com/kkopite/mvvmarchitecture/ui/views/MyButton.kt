package com.kkopite.mvvmarchitecture.ui.views

import android.content.Context
import android.util.AttributeSet
import android.widget.Button

class MyButton : Button {

    var isOpen = false
        set(value) {
            field = value
            val text = when (value) {
                true -> "open"
                else -> "close"
            }
            setText(text)
        }

    var mOnIsOpenChangeListener: OnIsOpenChangeListener? = null

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        // do something
        isOpen = false
        setOnClickListener {
            isOpen = !isOpen
            // 有变化了
            mOnIsOpenChangeListener?.onChange(isOpen)
        }
    }

    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)

}

interface OnIsOpenChangeListener {

    fun onChange(value: Boolean)
}

enum class STATE {
    OPEN, CLOSE
}