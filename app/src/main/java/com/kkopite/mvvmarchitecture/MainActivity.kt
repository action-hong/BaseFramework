package com.kkopite.mvvmarchitecture

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kkopite.mvvmarchitecture.databinding.ActivityMainBinding
import com.kkopite.mvvmarchitecture.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel.ViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewmodel = viewModel
    }
}
