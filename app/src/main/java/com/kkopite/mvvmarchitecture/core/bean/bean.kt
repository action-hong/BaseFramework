package com.kkopite.mvvmarchitecture.core.bean

data class BaseResponse<T>(val code: Int, val msg: String, val data: T)

data class FeedArticleData(
        var apkLink: String? = null,
        var author: String? = null,
        var chapterId: Int = 0,
        var chapterName: String? = null,
        var isCollect: Boolean = false,
        var courseId: Int = 0,
        var desc: String? = null,
        var envelopePic: String? = null,
        var id: Int = 0,
        var link: String? = null,
        var niceDate: String? = null,
        var origin: String? = null,
        var projectLink: String? = null,
        var superChapterId: Int = 0,
        var superChapterName: String? = null,
        var publishTime: Long = 0,
        var title: String? = null,
        var visible: Int = 0,
        var zan: Int = 0
)

data class FeedArticleListData(

        var curPage: Int = 0,
        var datas: List<FeedArticleData>? = null,
        var offset: Int = 0,
        var isOver: Boolean = false,
        var pageCount: Int = 0,
        var size: Int = 0,
        var total: Int = 0
)