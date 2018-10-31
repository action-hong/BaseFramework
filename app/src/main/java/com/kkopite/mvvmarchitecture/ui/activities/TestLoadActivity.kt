package com.kkopite.mvvmarchitecture.ui.activities;

import android.os.Bundle;

import com.kkopite.mvvmarchitecture.R;
import com.kkopite.mvvmarchitecture.libs.BaseActivity;
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresActivityViewModel;
import com.kkopite.mvvmarchitecture.viewmodels.TestLoadViewModel;

@RequiresActivityViewModel(TestLoadViewModel.ViewModel::class)
public class TestLoadActivity : BaseActivity<TestLoadViewModel.ViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_binding)
    }
}