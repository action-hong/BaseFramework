package com.kkopite.mvvmarchitecture.libs

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresActivityViewModel
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresFragmentViewModel
import kotlin.reflect.KClass

/**
 * 一个fragment 有两个viewmodel, 一个是共有的, 方便两个fragment通信, 另一个是自己使用的
 * Created by kkopite on 2018/9/27.
 */
open class BaseFragment<ShareViewModel: ActivityViewModel, viewModel: FragmentViewModel>: Fragment() {

    protected lateinit var mShareViewModel: ShareViewModel
    protected lateinit var mViewModel: viewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val annotationShare = this.javaClass.getAnnotation(RequiresActivityViewModel::class.java)
        @Suppress("UNCHECKED_CAST")
        val kClassShare = annotationShare?.value as KClass<ShareViewModel>
        mShareViewModel = ViewModelProviders.of(activity!!).get(kClassShare.java)

        val annotation = this.javaClass.getAnnotation(RequiresFragmentViewModel::class.java)
        @Suppress("UNCHECKED_CAST")
        val kClass = annotation?.value as KClass<viewModel>
        mViewModel = ViewModelProviders.of(this).get(kClass.java)

        mViewModel.onCreate(savedInstanceState)
        mViewModel.arguments(arguments)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewModel.onCreateView(inflater, container, savedInstanceState)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        mViewModel.onStart()
    }

    override fun onResume() {
        super.onResume()
        mViewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        mViewModel.onPause()
    }

    override fun onStop() {
        super.onStop()
        mViewModel.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewModel.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
        mViewModel.onDetach()
    }
}