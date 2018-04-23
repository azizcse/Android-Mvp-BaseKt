package com.core.kbasekit.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/13/2017 at 4:59 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Md. Imran Hossain on 4/23/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

open abstract class BaseViewHolder<T>(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    open abstract fun bind(item: T)
    protected fun setClickListener(vararg views: View) {
        for (view in views) {
            view.setOnClickListener(this)
        }
    }
}