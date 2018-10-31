package com.kkopite.mvvmarchitecture

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kkopite.mvvmarchitecture.databinding.ActivityTestBindingBinding
import com.kkopite.mvvmarchitecture.viewmodels.TestLoadViewModel

class TestBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_test_binding)

        val viewModel = ViewModelProviders.of(this).get(TestLoadViewModel.ViewModel::class.java)
        val binding: ActivityTestBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_binding)
        binding.viewmodel = viewModel
    }
}
