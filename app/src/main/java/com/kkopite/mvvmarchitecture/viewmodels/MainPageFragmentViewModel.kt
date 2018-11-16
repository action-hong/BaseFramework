package com.kkopite.mvvmarchitecture.viewmodels

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.kkopite.mvvmarchitecture.BR
import com.kkopite.mvvmarchitecture.R
import com.kkopite.mvvmarchitecture.core.bean.BannerData
import com.kkopite.mvvmarchitecture.core.bean.FeedArticleData
import com.kkopite.mvvmarchitecture.core.bean.FeedArticleListData
import com.kkopite.mvvmarchitecture.core.bean.test.User
import com.kkopite.mvvmarchitecture.libs.FragmentViewModel
import com.kkopite.mvvmarchitecture.libs.utils.execIOThenObserveOnMain
import com.kkopite.mvvmarchitecture.libs.utils.handleResult
import com.trello.rxlifecycle2.kotlin.bindToLifecycle
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.OnItemBind
import timber.log.Timber

interface MainPageFragmentViewModel {

    interface Inputs {

    }

    interface Outputs {

    }

    class ViewModel(application: Application) : FragmentViewModel(application), Inputs, Outputs {

        val inputs: Inputs = this
        val outpus: Outputs = this

        val name = "hello world"
        private var mCurrentPage = 0

        // load more, 监听, 为false的时候, 消失load more
        val mLoadMore = MutableLiveData<Boolean>()

        // 文章数据
        val feedItems: ObservableList<FeedArticleData> = ObservableArrayList()
        val feedItemBinding: ItemBinding<FeedArticleData> = ItemBinding.of(BR.item, R.layout.item_search_pager)

//        val items: ObservableList<User> = ObservableArrayList<User>()
//        //        val itemBinding: ItemBinding<User> = ItemBinding.of(BR.user, R.layout.item_test)
//        val itemBinding = OnItemBind<User> { itemBinding, position, _ ->
//            itemBinding.set(BR.user, R.layout.item_test)
//                    // 将该viewModel传到item, 方便item里面的事件可以再改viewModel处理
//                    .bindExtra(BR.viewmodel, this)
//        }

        fun autoRefresh() {
            mCurrentPage = 0
            initBannerData()
            initFeedArticleList()
        }

        private fun initBannerData() {
            mEnvironment.dataManager()
                    .getBannerData()
                    .execIOThenObserveOnMain()
                    .handleResult()
                    .bindToLifecycle(this)
                    .subscribe(object : Observer<List<BannerData>> {
                        override fun onComplete() {
                        }

                        override fun onSubscribe(d: Disposable) {
                        }

                        override fun onNext(t: List<BannerData>) {

                        }

                        override fun onError(e: Throwable) {
                            // 错误啦
                        }
                    })

        }

        fun initFeedArticleList() {
            mLoadMore.value = true
            mEnvironment.dataManager()
                    .getFeedArticleList(mCurrentPage)
                    .execIOThenObserveOnMain()
                    .handleResult()
                    .bindToLifecycle(this)
                    .subscribe(object : Observer<FeedArticleListData> {
                        override fun onComplete() {
                            mLoadMore.value = false
                        }

                        override fun onSubscribe(d: Disposable) {
                        }

                        override fun onNext(t: FeedArticleListData) {
                            t.datas?.let {
                                feedItems.addAll(it)
                            }
                            Timber.d(t.datas?.toString())
                            mCurrentPage++
                        }

                        override fun onError(e: Throwable) {
                            Timber.d(e)
                        }

                    })
        }
    }
}
