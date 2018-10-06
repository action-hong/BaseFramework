package com.kkopite.mvvmarchitecture.viewmodels;

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.kkopite.mvvmarchitecture.libs.ActivityViewModel

public interface MainViewModel {

    interface Inputs {

    }

    interface Outputs {

    }


    class ViewModel(application: Application) : ActivityViewModel(application), Inputs, Outputs {

        val inputs: Inputs = this
        val outpus: Outputs = this
        val text = MutableLiveData<String>()

        fun change(str: String) {
            text.value = str
        }
    }

}