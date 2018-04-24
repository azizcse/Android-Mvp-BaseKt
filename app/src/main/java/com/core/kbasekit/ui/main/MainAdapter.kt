package com.core.kbasekit.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.core.kbasekit.data.db.user.User
import com.core.kbasekit.databinding.ItemViewBinding
import com.core.kbasekit.ui.base.BaseAdapter
import com.core.kbasekit.ui.base.BaseViewHolder
import com.core.kbasekit.util.helper.TimeUtil

/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/14/2017 at 7:36 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Md. Imran Hossain on 4/24/2018.
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
        val layoutInflater = LayoutInflater.from(parent!!.context)
        var itemHolder = ItemViewBinding.inflate(layoutInflater, parent, false)
        return SimpleViewHolder(itemHolder)
    }

    private inner class SimpleViewHolder(itemView: ItemViewBinding) : BaseViewHolder<User>(itemView.root) {
        var binding: ItemViewBinding

        init {
            this.binding = itemView
            setClickListener(binding.layoutContent)
        }

        override fun bind(item: User) {
            binding.textName.text = item.name
            binding.textTime.text = TimeUtil.getTimeAgo(item.time)
        }

        override fun onClick(view: View) {
            when (view) {
                binding.layoutContent -> {
                    mListener!!.onItemClick(view, getItem(adapterPosition))
                }
            }
        }
    }
}