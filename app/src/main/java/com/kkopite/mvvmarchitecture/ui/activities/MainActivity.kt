package com.kkopite.mvvmarchitecture.ui.activities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.kkopite.mvvmarchitecture.R
import com.kkopite.mvvmarchitecture.app.Constants
import com.kkopite.mvvmarchitecture.libs.extension.fgTransaction
import com.kkopite.mvvmarchitecture.libs.qualifiers.RequiresActivityViewModel
import com.kkopite.mvvmarchitecture.libs.utils.disableShiftMode
import com.kkopite.mvvmarchitecture.ui.fragments.KnowledgeFragment
import com.kkopite.mvvmarchitecture.ui.fragments.MainPageFragment
import com.kkopite.mvvmarchitecture.ui.fragments.NavigationFragment
import com.kkopite.mvvmarchitecture.ui.fragments.ProjectFragment
import com.kkopite.mvvmarchitecture.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

@RequiresActivityViewModel(MainViewModel.ViewModel::class)
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val mFragments: MutableList<Fragment> = ArrayList()
    private val mMainPagerFragment by lazy {
        MainPageFragment()
    }
    private val mKnowledgeFragment by lazy {
        KnowledgeFragment()
    }
    private val mNavigationFragment by lazy {
        NavigationFragment()
    }
    private val mProjectFragment by lazy {
        ProjectFragment()
    }

    private var mLastFgIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        bottom_navigation_view.disableShiftMode()
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            val position = when(it.itemId) {
                R.id.tab_main_pager -> 0
                R.id.tab_knowledge_hierarchy -> 1
                R.id.tab_navigation -> 2
                R.id.tab_project -> 3
                else -> -1
            }
            loadPager(position)
            true
        }

        initPager(Constants.TYPE_MAIN_PAGER)
    }

    private fun initPager(position: Int) {
        if (position == -1) return
        initFragments()
        init()
        switchFragment(position)
    }

    private fun initFragments() {
        // 通知viewmodel当前界面
        mFragments.add(mMainPagerFragment)
        mFragments.add(mKnowledgeFragment)
        mFragments.add(mNavigationFragment)
        mFragments.add(mProjectFragment)
    }

    private fun init() {
        // 初始化 navigatorView
        // init BottomNavigationView
        // init DrawerLayout
    }

    private fun switchFragment(position: Int) {
        // 可以直接放databinding去, 根据当前position 放在viewmodel
        val tmp = if (position >= Constants.TYPE_COLLECT) {
            View.INVISIBLE
        } else {
            View.VISIBLE
        }
        bottom_navigation_view.visibility = tmp
        fab.visibility = tmp

        if (position >= mFragments.size) return

        supportFragmentManager.fgTransaction {
            val targetFg = mFragments[position]
            val lastFg = mFragments[mLastFgIndex]
            mLastFgIndex = position
//            replace(R.id.fragment_group, targetFg)
            hide(lastFg)
            if (!targetFg.isAdded) {
                add(R.id.fragment_group, targetFg)
            }
            show(targetFg)
        }
    }

    private fun loadPager(position: Int) {
        if (position == -1) return
        // 更换标题, 标题根据pagerType就可以替换了
        switchFragment(position)
        // fragment reload
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
