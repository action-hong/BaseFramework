package com.kkopite.mvvmarchitecture.viewmodels

import android.app.Application
import com.kkopite.mvvmarchitecture.libs.ActivityViewModel

interface NewsViewModel {

    interface Inputs {

    }

    interface Outputs {

    }


    class ViewModel(application: Application) : ActivityViewModel(application), Inputs, Outputs {

        val inputs: Inputs = this
        val outpus: Outputs = this
    }

}