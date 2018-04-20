package com.core.kbasekit.util.helper

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/*
* ****************************************************************************
* * Created by:
* * Name : Md. Imran Hossain
* * Date : 4/20/2018
* * Email : hossain.imran.cse11@gmail.com
* *
* * Purpose: All type of RecyclerView item decoration method
* *
* * Last Edited by : Md. Imran Hossain on 4/20/2018
* *
* * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
* ****************************************************************************
*/

class ItemDecorationUtil(space: Int) : RecyclerView.ItemDecoration() {

    val halfSpace: Int = space / 2

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {

        if (parent.paddingLeft != halfSpace) {
            parent.setPadding(halfSpace, halfSpace, halfSpace, halfSpace)
            parent.clipToPadding = false
        }
        outRect.top = halfSpace
        outRect.bottom = halfSpace
        outRect.left = halfSpace
        outRect.right = halfSpace
    }
}