package com.kkopite.mvvmarchitecture.libs.bindingadapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by kkopite on 2018/10/29.
 */

public class ViewGroupBindingAdapter {

    @BindingAdapter({"itemView", "viewModels"})
    public static void addViews(ViewGroup viewGroup, final ItemView itemView, final ObservableList<ViewModel> viewModelList) {
        if (viewModelList != null && !viewModelList.isEmpty()) {
            viewGroup.removeAllViews();
            for (ViewModel viewModel : viewModelList) {
                ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        itemView.layoutRes(), viewGroup, true);
                binding.setVariable(itemView.bindingVariable(), viewModel);
            }
        }
    }
}
