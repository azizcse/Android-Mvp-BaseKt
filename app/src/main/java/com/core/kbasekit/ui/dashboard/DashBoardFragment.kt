package com.core.kbasekit.ui.dashboard

import android.content.Intent
import android.view.View
import com.core.kbasekit.R
import com.core.kbasekit.databinding.FragmentDashBoardBinding
import com.core.kbasekit.ui.base.BaseFragment
import com.core.kbasekit.ui.main.MainActivity

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

class DashBoardFragment : BaseFragment<DashBoardMvpView, DashBoardPresenter>(), DashBoardMvpView {

    lateinit var mBindibng: FragmentDashBoardBinding

    override val getLayoutId: Int
        get() = R.layout.fragment_dash_board

    override val getMenuId: Int
        get() = -1

    override fun getPresenter(): DashBoardPresenter {
        return DashBoardPresenter()
    }

    override fun startUi() {
        mBindibng = getViewDataBinding() as FragmentDashBoardBinding
        setClickListener(mBindibng.buttonStartActivity)
    }

    override fun initView() {

    }

    override fun stopUi() {

    }

    override fun onClick(p0: View?) {
        when (p0) {
            mBindibng.buttonStartActivity -> {
                startActivity(Intent(activity, MainActivity::class.java))
            }
        }
    }
}
