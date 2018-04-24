package com.core.kbasekit.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View

/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/14/2017 at 6:44 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Imran Hossain on 04/24/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

abstract class BaseActivity<V : MvpView, P : BasePresenter<V>> : AppCompatActivity(), MvpView, View.OnClickListener {
    abstract val getLayoutId: Int
    abstract val getToolbarId: Int
    abstract val getMenuId: Int
    private val defaultValue: Int = 0

    internal abstract fun getPresenter(): P

    protected var presenter: P? = null
    private var mDataBinding: ViewDataBinding? = null

    abstract fun startUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayoutId > defaultValue) {
            updateUI(getLayoutId)
            if (getToolbarId > defaultValue) {
                val toolbar: Toolbar = findViewById(getToolbarId)
                setSupportActionBar(toolbar)
            }
            presenter = getPresenter()
            presenter?.onAttached(this as V)
        }
        startUi()
    }


    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDetached()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (getMenuId > defaultValue) {
            menuInflater.inflate(getMenuId, menu)
        }
        return true
    }

    override fun onResume() {
        super.onResume()

    }

    protected fun getViewDataBinding(): ViewDataBinding? {
        return mDataBinding
    }

    protected fun setClickListener(vararg views: View) {
        for (view in views) {
            view.setOnClickListener(this)
        }
    }

    private fun updateUI(layoutId: Int) {
        try {
            mDataBinding = DataBindingUtil.setContentView(this, layoutId)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (mDataBinding == null) {
            setContentView(layoutId)
        }
    }

}

