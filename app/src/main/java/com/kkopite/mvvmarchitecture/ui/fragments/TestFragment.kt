package com.kkopite.mvvmarchitecture.ui.fragments;

import android.arch.lifecycle.Observer
import android.os.Bundle;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kkopite.mvvmarchitecture.R
import com.kkopite.mvvmarchitecture.libs.BaseFragment
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresActivityViewModel
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresFragmentViewModel
import com.kkopite.mvvmarchitecture.viewmodels.MainViewModel
import com.kkopite.mvvmarchitecture.viewmodels.TestFragmentViewModel
import kotlinx.android.synthetic.main.fragment_test.*

@RequiresActivityViewModel(MainViewModel.ViewModel::class)
@RequiresFragmentViewModel(TestFragmentViewModel.ViewModel::class)
class TestFragment : BaseFragment<MainViewModel.ViewModel, TestFragmentViewModel.ViewModel>() {

 override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    return inflater.inflate(R.layout.fragment_test, container, false)
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mShareViewModel.text.observe(this, Observer {
            tv_rec.text = it
        })

        btn_send.setOnClickListener {
            val text = edit_msg.text.toString()
            mShareViewModel.change(text)
        }
    }

}
