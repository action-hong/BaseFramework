package com.kkopite.mvvmarchitecture.app

import android.graphics.Color
import android.graphics.Color.parseColor
import com.kkopite.mvvmarchitecture.R
import java.io.File.separator


object Constants {

    internal val BUGLY_ID = "a29fb52485"

    val MY_SHARED_PREFERENCE = "my_shared_preference"

    /**
     * url
     */
    val COOKIE = "Cookie"

    /**
     * Path
     */
//    val PATH_DATA = WanAndroidApp.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data"

//    val PATH_CACHE = PATH_DATA + "/NetCache"

    /**
     * Tag fragment classify
     */
    val TYPE_MAIN_PAGER = 0

    val TYPE_KNOWLEDGE = 1

    val TYPE_NAVIGATION = 2

    val TYPE_PROJECT = 3

    val TYPE_COLLECT = 4

    val TYPE_SETTING = 5


    /**
     * Bottom Navigation tab classify
     */
    val TAB_ONE = 0

    /**
     * Intent params
     */
    val ARG_PARAM1 = "param1"

    val ARG_PARAM2 = "param2"

    /**
     * Phone MANUFACTURER
     */
    val SAMSUNG = "samsung"

    /**
     * Tab colors
     */
    val TAB_COLORS = intArrayOf(Color.parseColor("#90C5F0"), Color.parseColor("#91CED5"), Color.parseColor("#F88F55"), Color.parseColor("#C0AFD0"), Color.parseColor("#E78F8F"), Color.parseColor("#67CCB7"), Color.parseColor("#F6BC7E"))


    /**
     * Main Pager
     */
    val SEARCH_TEXT = "search_text"

    val MENU_BUILDER = "MenuBuilder"

    val LOGIN_DATA = "login_data"

    val BANNER_DATA = "banner_data"

    val ARTICLE_DATA = "article_data"

    /**
     * Refresh theme color
     */
    val BLUE_THEME = R.color.colorPrimary

    /**
     * Avoid double click time area
     */
    val CLICK_TIME_AREA: Long = 1000

    val DOUBLE_INTERVAL_TIME: Long = 2000


    val ARTICLE_LINK = "article_link"

    val ARTICLE_TITLE = "article_title"

    val ARTICLE_ID = "article_id"

    val IS_COLLECT = "is_collect"

    val IS_COMMON_SITE = "is_common_site"

    val IS_COLLECT_PAGE = "is_collect_page"

    val CHAPTER_ID = "chapter_id"

    val IS_SINGLE_CHAPTER = "is_single_chapter"

    val CHAPTER_NAME = "is_chapter_name"

    val SUPER_CHAPTER_NAME = "super_chapter_name"

    internal val DB_NAME = "aws_wan_android.db"

    val CURRENT_PAGE = "current_page"

    val PROJECT_CURRENT_PAGE = "project_current_page"

    /**
     * Shared Preference key
     */
    val ACCOUNT = "account"

    val PASSWORD = "password"

    val LOGIN_STATUS = "login_status"

    val AUTO_CACHE_STATE = "auto_cache_state"

    val NO_IMAGE_STATE = "no_image_state"

    val NIGHT_MODE_STATE = "night_mode_state"

}
