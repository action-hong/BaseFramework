package com.kkopite.mvvmarchitecture.ui.fragments

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kkopite.mvvmarchitecture.R
import com.kkopite.mvvmarchitecture.databinding.FragmentMainpageBinding
import com.kkopite.mvvmarchitecture.libs.BaseFragment
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresActivityViewModel
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresFragmentViewModel
import com.kkopite.mvvmarchitecture.viewmodels.MainViewModel
import com.kkopite.mvvmarchitecture.viewmodels.MainPageFragmentViewModel
import kotlinx.android.synthetic.main.fragment_mainpage.*

@RequiresActivityViewModel(MainViewModel.ViewModel::class)
@RequiresFragmentViewModel(MainPageFragmentViewModel.ViewModel::class)
class MainPageFragment : BaseFragment<MainViewModel.ViewModel, MainPageFragmentViewModel.ViewModel>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding: FragmentMainpageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mainpage, container, false)
        binding.viewmodel = mViewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel.autoRefresh()

        srl.setEnableLoadMore(true)
        srl.setOnLoadMoreListener {
            mViewModel.initFeedArticleList()
        }

        mViewModel.mLoadMore.observe(this, Observer<Boolean> {
            if (it == false) {
                srl.finishLoadMore(2000)
            }
        })



    }

}
