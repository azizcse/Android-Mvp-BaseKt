package com.core.kbasekit.ui.message

import android.view.View
import com.core.kbasekit.R
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

class MessageFragment : BaseFragment<MessageMvpView, MessagePresenter>(), MessageMvpView {

    override val getLayoutId: Int
        get() = R.layout.fragment_message

    override val getMenuId: Int
        get() = -1

    override fun getPresenter(): MessagePresenter {
        return MessagePresenter()
    }

    override fun startUi() {

    }

    override fun initView() {

    }

    override fun stopUi() {

    }

    override fun onClick(p0: View?) {

    }
}