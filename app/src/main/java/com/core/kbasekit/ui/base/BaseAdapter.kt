package com.core.kbasekit.ui.base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/13/2017 at 4:56 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Imran Hossain on 04/23/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

open abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private val mItemList: ArrayList<T> = arrayListOf()
    protected var mListener: ItemClickListener<T>? = null

    override fun getItemCount(): Int {
        return mItemList.size
    }

    fun addItem(item: T) {
        mItemList.add(item)
        notifyItemInserted(mItemList.size - 1)
    }

    fun getItem(pos: Int): T {
        return mItemList.get(pos)
    }

    fun addItems(itemList: List<T>) {
        mItemList.addAll(itemList)
        notifyDataSetChanged()
    }

    fun removeItem(t: T) {
        var index: Int = mItemList.indexOf(t);

        if (index < 0 || index >= mItemList.size) return

        mItemList.removeAt(index)
        notifyItemMoved(index, mItemList.size)
    }

    fun clear() {
        mItemList.clear()
        notifyDataSetChanged()
    }

    fun getItems(): List<T> {
        return mItemList
    }

    fun updateItem(i: T) {
        var item = findItem(i)
        if (item != null) {
            val index = mItemList.indexOf(item);
            mItemList.set(index, i)
            notifyItemChanged(index)
        }
    }

    fun findItem(item: T): T? {
        for (tItem in mItemList) {
            if (isEqual(item, tItem)) {
                return tItem
            }
        }
        return null
    }

    fun setClickLisener(listener: ItemClickListener<T>) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<T> {
        return newViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>?, position: Int) {
        var item: T = getItem(position)
        holder?.bind(item)
    }

    abstract fun newViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<T>
    abstract fun isEqual(leftItem: T, rightItem: T): Boolean
}