package com.kkopite.mvvmarchitecture.libs

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 一个fragment 有两个viewmodel, 一个是共有的, 方便两个fragment通信, 另一个是自己使用的
 * Created by kkopite on 2018/9/27.
 */
public class BaseFragment<ShareViewModel: ActivityViewModel, viewModel: FragmentViewModel>: Fragment() {


    protected lateinit var mShareViewModel: ShareViewModel
    protected lateinit var mViewModel: viewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mShareViewModel = ViewModelProvider.AndroidViewModelFactory(activity!!.application).create(mShareViewModel.javaClass)
        mViewModel = ViewModelProvider.AndroidViewModelFactory(activity!!.application).create(mViewModel.javaClass)

        mViewModel.arguments(arguments)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }
}