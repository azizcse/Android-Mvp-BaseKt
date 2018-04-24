package com.core.kbasekit.ui.base

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*

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

abstract class BaseFragment<V : MvpView, P : BasePresenter<V>> : Fragment(), MvpView, View.OnClickListener {

    abstract val getLayoutId: Int
    abstract val getMenuId: Int
    private val mDefaultValue: Int = 0

    internal abstract fun getPresenter(): P

    protected var presenter: P? = null
    private var mViewDataBinding: ViewDataBinding? = null

    abstract fun startUi()
    abstract fun stopUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getMenuId > mDefaultValue) {
            setHasOptionsMenu(true)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (getLayoutId <= mDefaultValue) {
            return super.onCreateView(inflater, container, savedInstanceState)
        }
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId, container, false)
        if (mViewDataBinding == null) {
            var view = inflater!!.inflate(getLayoutId, container, false)
            return view
        }
        return this.mViewDataBinding!!.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = getPresenter()
        presenter?.onAttached(this as V)
        startUi()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        if (getMenuId > mDefaultValue) {
            inflater!!.inflate(getMenuId, menu)
            super.onCreateOptionsMenu(menu, inflater)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDetached()
        stopUi()
    }

    protected fun getViewDataBinding(): ViewDataBinding? {
        return mViewDataBinding
    }

    protected fun setClickListener(vararg views: View) {
        for (view in views) {
            view.setOnClickListener(this)
        }
    }
}