package com.core.kbasekit.ui.base

import io.reactivex.disposables.CompositeDisposable

/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/14/2017 at 6:49 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Imran Hossain on 4/20/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

abstract class BasePresenter<V : MvpView> : Presenter<V> {

    private var mvpView: V? = null
    private var compositeDisposable: CompositeDisposable? = null

    constructor() {
        compositeDisposable = CompositeDisposable()
    }

    override fun onAttached(mvpView: V) {
        this.mvpView = mvpView
        this.mvpView!!.initView()
    }

    override fun onDetached() {
        this.mvpView = null
    }

    fun getMvpView(): V? {
        return mvpView
    }

    fun getDisposable(): CompositeDisposable {
        return compositeDisposable!!
    }
}