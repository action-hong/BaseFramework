package com.kkopite.mvvmarchitecture.viewmodels;

import android.app.Application
import com.kkopite.mvvmarchitecture.libs.FragmentViewModel;

interface TestFragmentViewModel {

  interface Inputs {

  }

  interface Outputs {

  }

  class ViewModel(application: Application) : FragmentViewModel(application), Inputs, Outputs {

    val inputs: Inputs = this
    val outpus: Outputs = this
  }
}
