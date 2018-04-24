package com.core.kbasekit.ui.home

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.View
import com.core.kbasekit.R
import com.core.kbasekit.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

/*
* ****************************************************************************
* * Created by:
* * Name : Md. Imran Hossain
* * Date : 4/24/2018
* * Email : hossain.imran.cse11@gmail.com
* *
* * Last Edited by : Md. Imran Hossain on 4/24/2018
* *
* * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
* ****************************************************************************
*/

class HomeActivity : BaseActivity<HomeMvpView, HomePresenter>(), HomeMvpView {

    override val getLayoutId: Int
        get() = R.layout.activity_home

    override val getToolbarId: Int
        get() = R.id.toolbar

    override val getMenuId: Int
        get() = -1

    override fun getPresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun startUi() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        presenter?.processClick(R.id.navigation_dashboard)
    }

    override fun initView() {

    }

    override fun stoptUi() {

    }

    override fun openFragment(fragment: Fragment) {
        commitFragment(R.id.frame_container, fragment)
    }

    override fun onClick(p0: View?) {

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_dashboard -> {
                presenter?.processClick(item.itemId)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_message -> {
                presenter?.processClick(item.itemId)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                presenter?.processClick(item.itemId)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
