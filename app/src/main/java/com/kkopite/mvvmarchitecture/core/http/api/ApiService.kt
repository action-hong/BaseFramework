package com.kkopite.mvvmarchitecture.core.http.api

import com.kkopite.mvvmarchitecture.core.bean.BaseResponse
import com.kkopite.mvvmarchitecture.core.bean.FeedArticleListData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("article/list/{num}/json")
    fun getFeedArticleList(@Path("num") num: Int): Observable<BaseResponse<FeedArticleListData>>

}