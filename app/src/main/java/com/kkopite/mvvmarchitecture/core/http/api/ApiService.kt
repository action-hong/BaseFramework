package com.kkopite.mvvmarchitecture.core.http.api

import com.kkopite.mvvmarchitecture.core.bean.BannerData
import com.kkopite.mvvmarchitecture.core.bean.BaseResponse
import com.kkopite.mvvmarchitecture.core.bean.FeedArticleListData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path



interface ApiService {

    @GET("article/list/{num}/json")
    fun getFeedArticleList(@Path("num") num: Int): Observable<BaseResponse<FeedArticleListData>>

    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return 广告栏数据
     */
    @GET("banner/json")
    fun getBannerData(): Observable<BaseResponse<List<BannerData>>>

}