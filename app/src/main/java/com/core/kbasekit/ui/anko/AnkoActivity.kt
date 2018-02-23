package com.core.kbasekit.ui.anko

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.core.kbasekit.R
import com.core.kbasekit.ui.base.BaseActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat

class AnkoActivity : BaseActivity<AnkoMvpView, AnkoPresenter>(),AnkoMvpView {

    override val getLayoutId: Int
        get() = R.layout.activity_anko
    override val getMenuId: Int
        get() = 0
    override val getMvpView: AnkoMvpView
        get() = this

    override fun getPresenter(): AnkoPresenter {
        return AnkoPresenter()
    }

    override fun startUi() {
        findViewById<Button>(R.id.button_toast).setOnClickListener(this)
        findViewById<Button>(R.id.button_dialog).setOnClickListener(this)
        findViewById<Button>(R.id.button_selector).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.button_toast){
            showAlert()
        }else if(v?.id == R.id.button_dialog){
            progressDialog()
        }else if(v?.id == R.id.button_selector){
            selector()
        }
    }

    private fun showAlert(){
       // alert(Appcompat, "Some text message").show()
       /* alert {
            customView {
                editText()
            }
        }.show()*/
        alert ("Hi, I'm Roy", "Have you tried turning it off and on again?") {
            yesButton { toast("Oh…") }
            noButton {}
        }.show()
    }

    private fun progressDialog(){
        val dialog = progressDialog(message = "Please wait a bit…", title = "Fetching data")
        dialog.progress = 20;
    }

    private fun selector(){
        val countries = listOf("Russia", "USA", "Japan", "Australia")
        selector("Where are you from?", countries, { listener, i->
            toast("So you're living in ${countries[i]}, right?")
        })
    }

    var listener =  object : DialogInterface {
        override fun dismiss() {
            toast("dismiss()")
        }

        override fun cancel() {
            toast("cancel()")
        }

    }


}
