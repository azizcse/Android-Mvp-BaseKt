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
open class MainAdapter : BaseAdapter<Model>{
    public var mContext : Context? = null
    constructor(context: Context){
        mContext = context
    }
    public fun showToast(){
        Toast.makeText(mContext,"Hello", Toast.LENGTH_LONG).show()
    }

    override fun isEqual(leftItem: Model, rightItem: Model): Boolean {
        return false;
    }

    override fun newViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<Model> {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false)

        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Model>?, position: Int) {
        var list : ArrayList<String> = arrayListOf()
        list.add("Aziz")
        list.add("Aziz 1")
        list.add("Aziz 2")
        list.add("Aziz 3")
        list.add("Aziz 4")
        var model = Model(list)
        holder?.bind(model, mContext!!)
    }

    override fun getItemCount(): Int {
        return 1
    }

    class SimpleViewHolder(itemView : View) : BaseViewHolder<Model>(itemView){
        val linearLayout : LinearLayout = itemView.findViewById(R.id.parentViewHolder)

        override fun bind(item: Model, context: Context) {
            var list = item.list
            var textView: TextView? = null
            val inflater = LayoutInflater.from(context)
            linearLayout.removeAllViews()

            for(item in list){
                textView = inflater.inflate(R.layout.item_name_2, linearLayout, false) as TextView

                textView.text = item
                linearLayout.addView(textView)
            }}
    }
}