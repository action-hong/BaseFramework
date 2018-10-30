package com.kkopite.mvvmarchitecture.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle

import com.kkopite.mvvmarchitecture.R
import com.kkopite.mvvmarchitecture.libs.BaseActivity
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresActivityViewModel
import com.kkopite.mvvmarchitecture.viewmodels.NewsViewModel
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

@RequiresActivityViewModel(NewsViewModel.ViewModel::class)
class NewsActivity : BaseActivity<NewsViewModel.ViewModel>() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        environment().dataManager().getFeedArticleList(0)
                .subscribeOn(Schedulers.io())
                .subscribe {
                    Timber.d(it.data.toString())
                }
    }
}