package com.core.kbasekit.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/4/2018 at 10:19 AM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/4/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

abstract class BaseFragment<V : MvpView, P : BasePresenter<V>>: Fragment(), MvpView, OnClickListener {

    abstract val getLayoutId: Int
    abstract val getMenuId: Int
    abstract val getMvpView: V
    private val defaultValue : Int = -1

    internal abstract fun getPresenter() : P

    protected var presenter: P? = null
    protected var mvpView: V? = null


    abstract fun startUi()

    abstract fun stopUi()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(getLayoutId, container, false)
        presenter = getPresenter()
        mvpView = getMvpView
        presenter?.onAttached(mvpView!!)
        startUi()
        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDetached()
        stopUi()
    }
    override fun onClick(v: View?) {

    }
}