package com.core.kbasekit.ui.settings

import android.content.Intent
import android.view.MenuItem
import android.view.View
import com.core.kbasekit.R
import com.core.kbasekit.databinding.FragmentSettingsBinding
import com.core.kbasekit.ui.anko.AnkoActivity
import com.core.kbasekit.ui.base.BaseFragment

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

class SettingsFragment : BaseFragment<SettingsMvpView, SettingsPresenter>(), SettingsMvpView {
    lateinit var mBinding: FragmentSettingsBinding
    override val getLayoutId: Int
        get() = R.layout.fragment_settings

    override val getMenuId: Int
        get() = R.menu.main_menu

    override fun getPresenter(): SettingsPresenter {
        return SettingsPresenter()
    }

    override fun startUi() {
        mBinding = getViewDataBinding() as FragmentSettingsBinding
        mBinding.textMessage.text = "Settings"
    }

    override fun initView() {

    }

    override fun stopUi() {

    }

    override fun onClick(p0: View?) {

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_settings -> {
                //Toaster.showShort("click : " + item.title)
                startActivity(Intent(activity, AnkoActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
