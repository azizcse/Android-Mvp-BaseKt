package com.core.kbasekit.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import com.core.kbasekit.BaseApp


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/14/2017 at 6:44 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/14/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

abstract class BaseActivity<V : MvpView, P : BasePresenter<V>> : AppCompatActivity(), MvpView, View.OnClickListener {
    abstract val getLayoutId: Int
    abstract val getMenuId: Int
    abstract val getMvpView: V
    private val defaultValue : Int = 0

    internal abstract fun getPresenter() : P

    protected var presenter: P? = null
    protected var mvpView: V? = null


    abstract fun startUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId)
        mvpView = getMvpView
        presenter = getPresenter()
        presenter?.onAttached(getMvpView)
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
        if(getMenuId > defaultValue){
            menuInflater.inflate(getMenuId, menu)
        }
        return true
    }

    override fun onResume() {
        super.onResume()

    }

}

