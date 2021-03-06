package com.kkopite.mvvmarchitecture.core

import com.kkopite.mvvmarchitecture.core.bean.BaseResponse
import com.kkopite.mvvmarchitecture.core.bean.FeedArticleListData
import com.kkopite.mvvmarchitecture.core.http.api.ApiService
import io.reactivex.Observable

class DataManager(private val apiService: ApiService): ApiService {

    override fun getFeedArticleList(num: Int): Observable<BaseResponse<FeedArticleListData>> {
        return apiService.getFeedArticleList(num)
    }

}