package com.core.kbasekit.ui.anko

import android.content.DialogInterface
import android.view.View
import com.core.kbasekit.R
import com.core.kbasekit.databinding.ActivityAnkoBinding
import com.core.kbasekit.ui.base.BaseActivity
import org.jetbrains.anko.*

/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/2/2018 at 1:19 PM.
*  * Email : azizul@w3engineers.com
*  *
*  * Last edited by : Md. Imran Hossain on 4/24/2018.
*  *
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
*  ****************************************************************************
*/

class AnkoActivity : BaseActivity<AnkoMvpView, AnkoPresenter>(), AnkoMvpView {
    lateinit var mBinding: ActivityAnkoBinding

    override val getLayoutId: Int
        get() = R.layout.activity_anko

    override val getToolbarId: Int
        get() = R.id.toolbar

    override val getMenuId: Int
        get() = R.menu.main_menu

    override fun getPresenter(): AnkoPresenter {
        return AnkoPresenter()
    }

    override fun startUi() {
        mBinding = getViewDataBinding() as ActivityAnkoBinding
        setClickListener(mBinding.buttonToast, mBinding.buttonDialog, mBinding.buttonSelector)
    }

    override fun initView() {
        supportActionBar?.setLogo(R.drawable.ic_menu)
    }

    override fun stoptUi() {

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.button_toast) {
            showAlert()
        } else if (v?.id == R.id.button_dialog) {
            progressDialog()
        } else if (v?.id == R.id.button_selector) {
            selector()
        }
    }

    private fun showAlert() {
        // alert(Appcompat, "Some text message").show()
        /* alert {
             customView {
                 editText()
             }
         }.show()*/
        alert("Hi, I'm Roy", "Have you tried turning it off and on again?") {
            yesButton { toast("Oh…") }
            noButton {}
        }.show()
    }

    private fun progressDialog() {
        val dialog = progressDialog(message = "Please wait a bit…", title = "Fetching data")
        dialog.progress = 20;
    }

    private fun selector() {
        val countries = listOf("Russia", "USA", "Japan", "Australia")
        selector("Where are you from?", countries, { listener, i ->
            toast("So you're living in ${countries[i]}, right?")
        })
    }

    var listener = object : DialogInterface {
        override fun dismiss() {
            toast("dismiss()")
        }

        override fun cancel() {
            toast("cancel()")
        }

    }
}
