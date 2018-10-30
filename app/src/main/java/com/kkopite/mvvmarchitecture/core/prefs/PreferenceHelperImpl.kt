package com.kkopite.mvvmarchitecture.core.prefs

import android.R.id.edit
import android.content.Context
import com.google.common.net.HttpHeaders.COOKIE
import android.provider.Telephony.Carriers.PASSWORD
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.kkopite.mvvmarchitecture.app.Constants
import javax.inject.Inject


class PreferenceHelperImpl @Inject
internal constructor(context: Context) : PreferenceHelper {

    private val mPreferences: SharedPreferences = context.getSharedPreferences(Constants.MY_SHARED_PREFERENCE, Context.MODE_PRIVATE)

    override fun setLoginAccount(account: String) {
        mPreferences.edit().putString(Constants.ACCOUNT, account).apply()
    }

    override fun setLoginPassword(password: String) {
        mPreferences.edit().putString(Constants.PASSWORD, password).apply()
    }

    override fun getLoginAccount(): String {
        return mPreferences.getString(Constants.ACCOUNT, "")
    }

    override fun getLoginPassword(): String {
        return mPreferences.getString(Constants.PASSWORD, "")
    }

    override fun setLoginStatus(isLogin: Boolean) {
        mPreferences.edit().putBoolean(Constants.LOGIN_STATUS, isLogin).apply()
    }

    override fun getLoginStatus(): Boolean {
        return mPreferences.getBoolean(Constants.LOGIN_STATUS, false)
    }

    override fun setCookie(domain: String, cookie: String) {
        mPreferences.edit().putString(domain, cookie).apply()
    }

    override fun getCookie(domain: String): String {
        return mPreferences.getString(Constants.COOKIE, "")
    }

    override fun setCurrentPage(position: Int) {
        mPreferences.edit().putInt(Constants.CURRENT_PAGE, position).apply()
    }

    override fun getCurrentPage(): Int {
        return mPreferences.getInt(Constants.CURRENT_PAGE, 0)
    }

    override fun setProjectCurrentPage(position: Int) {
        mPreferences.edit().putInt(Constants.PROJECT_CURRENT_PAGE, position).apply()
    }

    override fun getProjectCurrentPage(): Int {
        return mPreferences.getInt(Constants.PROJECT_CURRENT_PAGE, 0)
    }

    override fun getAutoCacheState(): Boolean {
        return mPreferences.getBoolean(Constants.AUTO_CACHE_STATE, true)
    }

    override fun getNoImageState(): Boolean {
        return mPreferences.getBoolean(Constants.NO_IMAGE_STATE, false)
    }

    override fun getNightModeState(): Boolean {
        return mPreferences.getBoolean(Constants.NIGHT_MODE_STATE, false)
    }

    override fun setNightModeState(b: Boolean) {
        mPreferences.edit().putBoolean(Constants.NIGHT_MODE_STATE, b).apply()
    }

    override fun setNoImageState(b: Boolean) {
        mPreferences.edit().putBoolean(Constants.NO_IMAGE_STATE, b).apply()
    }

    override fun setAutoCacheState(b: Boolean) {
        mPreferences.edit().putBoolean(Constants.AUTO_CACHE_STATE, b).apply()
    }


}