package com.kkopite.mvvmarchitecture.core.bean

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(val errorCode: Int, val errorMsg: String, val data: T)

data class FeedArticleData(
        @SerializedName("apkLink") var apkLink: String? = null,
        @SerializedName("author") var author: String? = null,
        @SerializedName("chapterId") var chapterId: Int = 0,
        @SerializedName("chapterName") var chapterName: String? = null,
        @SerializedName("collect") var collect: Boolean = false,
        @SerializedName("courseId") var courseId: Int = 0,
        @SerializedName("desc") var desc: String? = null,
        @SerializedName("envelopePic") var envelopePic: String? = null,
        @SerializedName("id") var id: Int = 0,
        @SerializedName("link") var link: String? = null,
        @SerializedName("niceDate") var niceDate: String? = null,
        @SerializedName("origin") var origin: String? = null,
        @SerializedName("projectLink") var projectLink: String? = null,
        @SerializedName("superChapterId") var superChapterId: Int = 0,
        @SerializedName("superChapterName") var superChapterName: String? = null,
        @SerializedName("publishTime") var publishTime: Long = 0,
        @SerializedName("title") var title: String? = null,
        @SerializedName("visible") var visible: Int = 0,
        @SerializedName("zan") var zan: Int = 0
)

data class FeedArticleListData(

        @SerializedName("curPage") var curPage: Int = 0,
        @SerializedName("datas") var datas: List<FeedArticleData>? = null,
        @SerializedName("offset") var offset: Int = 0,
        @SerializedName("isOver") var isOver: Boolean = false,
        @SerializedName("pageCount") var pageCount: Int = 0,
        @SerializedName("size") var size: Int = 0,
        @SerializedName("total") var total: Int = 0
)

data class BannerData(

        @SerializedName("id") var id: Int = 0,
        @SerializedName("url") var url: String? = null,
        @SerializedName("imagePath") var imagePath: String? = null,
        @SerializedName("title") var title: String? = null,
        @SerializedName("desc") var desc: String? = null,
        @SerializedName("isVisible") var isVisible: Int = 0,
        @SerializedName("order") var order: Int = 0,
        @SerializedName("type") var type: Int = 0
)