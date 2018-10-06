package com.kkopite.mvvmarchitecture.ui.activities;

import android.os.Bundle;

import com.kkopite.mvvmarchitecture.R;
import com.kkopite.mvvmarchitecture.libs.BaseActivity;
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresActivityViewModel;
import com.kkopite.mvvmarchitecture.viewmodels.MainViewModel;

@RequiresActivityViewModel(MainViewModel.ViewModel::class)
public class MainActivity : BaseActivity<MainViewModel.ViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}