package com.core.kbasekit.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.core.kbasekit.R
import com.core.kbasekit.data.db.user.User
import com.core.kbasekit.ui.base.BaseAdapter
import com.core.kbasekit.ui.base.BaseViewHolder
import com.core.kbasekit.util.helper.SharedPref
import com.core.kbasekit.util.helper.TimeUtil
import java.util.*

/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/14/2017 at 7:36 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Md. Imran Hossain on 4/23/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

open class MainAdapter : BaseAdapter<User> {
    var mContext: Context? = null

    constructor(context: Context) {
        mContext = context
    }

    override fun isEqual(leftItem: User, rightItem: User): Boolean {
        return leftItem.id.equals(rightItem.id)
    }

    override fun newViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<User> {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_view, parent, false)
        return SimpleViewHolder(view)
    }

    private inner class SimpleViewHolder(itemView: View) : BaseViewHolder<User>(itemView) {

        var name: TextView
        var time: TextView

        init {
            name = itemView.findViewById(R.id.text_name)
            time = itemView.findViewById(R.id.text_time)
            setClickListener(itemView)
        }

        override fun bind(item: User) {
            name.text = item.name
            time.text = TimeUtil.getTimeAgo(item.time)
        }

        override fun onClick(view: View) {
            mListener!!.onItemClick(view, getItem(adapterPosition))
        }
    }
}