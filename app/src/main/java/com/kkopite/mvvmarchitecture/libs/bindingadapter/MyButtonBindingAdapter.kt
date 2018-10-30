package com.kkopite.mvvmarchitecture.libs.bindingadapter

import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import com.kkopite.mvvmarchitecture.ui.views.MyButton
import com.kkopite.mvvmarchitecture.ui.views.OnIsOpenChangeListener

// 自己造一个简单的双向绑定view
object MyButtonBindingAdapter {

    @BindingAdapter("isOpen")
    @JvmStatic fun setValue(view: MyButton, newValue: Boolean) {
        if (view.isOpen != newValue) {
            view.isOpen = newValue
        }
    }

    // event="app:isOpenAttrChange" 这一串不能少了, 不然会生成失败
    @InverseBindingAdapter(attribute = "isOpen", event="app:isOpenAttrChange")
    @JvmStatic fun getValue(view: MyButton): Boolean {
        return view.isOpen
    }

    // 监听, 何时会改变 去通知
    @BindingAdapter("app:isOpenAttrChange")
    @JvmStatic fun setListeners(view: MyButton, attrChange: InverseBindingListener) {
        view.mOnIsOpenChangeListener = object : OnIsOpenChangeListener {
            override fun onChange(value: Boolean) {
                // 该属性改变了, 去通知一下
                attrChange.onChange()
            }
        }
    }
}