package com.core.kbasekit.ui.home

import android.support.v4.app.Fragment
import com.core.kbasekit.R
import com.core.kbasekit.ui.base.BasePresenter
import com.core.kbasekit.ui.dashboard.DashBoardFragment
import com.core.kbasekit.ui.message.MessageFragment
import com.core.kbasekit.ui.settings.SettingsFragment

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

class HomePresenter : BasePresenter<HomeMvpView>() {
    lateinit var fragment: Fragment
    fun processClick(id: Int) {
        when (id) {
        // home fragment
            R.id.navigation_dashboard -> {
                fragment = DashBoardFragment()
            }
        // dashboard fragment
            R.id.navigation_message -> {
                fragment = MessageFragment()
            }
        // notification fragment
            R.id.navigation_settings -> {
                fragment = SettingsFragment()
            }
        }
        getMvpView()?.openFragment(fragment)
    }
}