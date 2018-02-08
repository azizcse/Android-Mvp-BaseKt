package com.core.kbasekit.ui.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/13/2017 at 4:59 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/13/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

open abstract class BaseViewHolder<T>(itemView : View ?) : RecyclerView.ViewHolder(itemView) {
    open abstract fun bind(item : T);
}