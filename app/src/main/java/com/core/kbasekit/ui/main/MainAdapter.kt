package com.core.kbasekit.ui.main

import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.core.kbasekit.R
import com.core.kbasekit.data.db.contact.Contact
import com.core.kbasekit.data.db.ex.Model
import com.core.kbasekit.data.db.user.User
import com.core.kbasekit.ui.base.BaseAdapter
import com.core.kbasekit.ui.base.BaseViewHolder


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/14/2017 at 7:36 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/14/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/
open class MainAdapter : BaseAdapter<User>{
    public var mContext : Context? = null
    constructor(context: Context){
        mContext = context
    }

    override fun isEqual(leftItem: User, rightItem: User): Boolean {
        return leftItem.id.equals(rightItem.id);
    }

    override fun newViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<User> {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false)
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<User>?, position: Int) {
        val user = getItem(position)
        holder?.bind(user)
    }

    private inner class SimpleViewHolder(itemView : View) : BaseViewHolder<User>(itemView){
       var nameTv : TextView

        init {
            nameTv = itemView.findViewById(R.id.name);
        }
        override fun bind(item: User) {
            nameTv.text = item.name;
        }
    }
}