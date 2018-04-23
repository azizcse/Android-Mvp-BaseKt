package com.core.kbasekit.ui.splash

import android.content.Intent
import android.view.View
import com.core.kbasekit.R
import com.core.kbasekit.ui.base.BaseActivity
import com.core.kbasekit.ui.main.MainActivity
import com.core.kbasekit.util.helper.HandlerUtil
import yanzhikai.textpath.SyncTextPathView

/*
* ****************************************************************************
* * Created by:
* * Name : Md. Imran Hossain
* * Date : 4/23/2018
* * Email : hossain.imran.cse11@gmail.com
* *
* * Last Edited by : Md. Imran Hossain on 4/23/2018
* *
* * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
* ****************************************************************************
*/

class SplashActivity : BaseActivity<SplashMvpView, SplashPresenter>(), SplashMvpView {

    var mTextMessage: SyncTextPathView? = null

    override val getToolbarId: Int
        get() = -1

    override val getMenuId: Int
        get() = -1

    override fun getPresenter(): SplashPresenter {
        return SplashPresenter()
    }

    override val getLayoutId: Int
        get() = R.layout.activity_splash

    override fun startUi() {
        mTextMessage!!.startAnimation(0F, 1F)
        HandlerUtil.getInstance().postForeground(Runnable {
            run {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }, 3000)
    }

    override fun initView() {
        mTextMessage = findViewById(R.id.text_path)
    }

    override fun onClick(p0: View?) {

    }
}
