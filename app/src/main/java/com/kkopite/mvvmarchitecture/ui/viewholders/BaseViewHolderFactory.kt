package com.kkopite.mvvmarchitecture.ui.viewholders

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.kkopite.mvvmarchitecture.BR
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter

class BaseViewHolderFactory: BindingRecyclerViewAdapter.ViewHolderFactory {
    override fun createViewHolder(binding: ViewDataBinding?): RecyclerView.ViewHolder {
        val vh = object: RecyclerView.ViewHolder(binding?.root) {

        }
        // 将viewholder绑定进去, 方便item点击的知道是点哪一个position
        binding?.setVariable(BR.viewholder, vh)
        return vh
    }
}