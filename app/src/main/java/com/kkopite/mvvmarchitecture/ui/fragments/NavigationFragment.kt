package com.kkopite.mvvmarchitecture.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kkopite.mvvmarchitecture.R
import com.kkopite.mvvmarchitecture.libs.BaseFragment
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresActivityViewModel
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresFragmentViewModel
import com.kkopite.mvvmarchitecture.viewmodels.MainViewModel
import com.kkopite.mvvmarchitecture.viewmodels.NavigationFragmentViewModel

@RequiresActivityViewModel(MainViewModel.ViewModel::class)
@RequiresFragmentViewModel(NavigationFragmentViewModel.ViewModel::class)
class NavigationFragment : BaseFragment<MainViewModel.ViewModel, NavigationFragmentViewModel.ViewModel>() {

 override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    return inflater.inflate(R.layout.fragment_navigation, container, false)
  }

}
