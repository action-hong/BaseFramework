package com.kkopite.mvvmarchitecture.core.prefs

interface PreferenceHelper {

    /**
     * Set login account
     *
     * @param account Account
     */
    fun setLoginAccount(account: String)

    /**
     * Set login password
     *
     * @param password Password
     */
    fun setLoginPassword(password: String)

    /**
     * Get login account
     *
     * @return account
     */
    fun getLoginAccount(): String

    /**
     * Get login password
     *
     * @return password
     */
    fun getLoginPassword(): String

    /**
     * Set login status
     *
     * @param isLogin IsLogin
     */
    fun setLoginStatus(isLogin: Boolean)

    /**
     * Get login status
     *
     * @return login status
     */
    fun getLoginStatus(): Boolean

    /**
     * Set cookie
     *
     * @param domain Domain
     * @param cookie Cookie
     */
    fun setCookie(domain: String, cookie: String)

    /**
     * Get cookie
     *
     * @param domain Domain
     * @return cookie
     */
    fun getCookie(domain: String): String

    /**
     * Set current page
     *
     * @param position Position
     */
    fun setCurrentPage(position: Int)

    /**
     * Get current page
     *
     * @return current page
     */
    fun getCurrentPage(): Int

    /**
     * Set project current page
     *
     * @param position Position
     */
    fun setProjectCurrentPage(position: Int)

    /**
     * Get project current page
     *
     * @return current page
     */
    fun getProjectCurrentPage(): Int

    /**
     * Get auto cache state
     *
     * @return if auto cache state
     */
    fun getAutoCacheState(): Boolean

    /**
     * Get no image state
     *
     * @return if has image state
     */
    fun getNoImageState(): Boolean

    /**
     * Get night mode state
     *
     * @return if is night mode
     */
    fun getNightModeState(): Boolean

    /**
     * Set night mode state
     *
     * @param b current night mode state
     */
    fun setNightModeState(b: Boolean)

    /**
     * Set no image state
     *
     * @param b current no image state
     */
    fun setNoImageState(b: Boolean)

    /**
     * Set auto cache state
     *
     * @param b current auto cache state
     */
    fun setAutoCacheState(b: Boolean)
}