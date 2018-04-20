package com.core.kbasekit.util.helper

import android.content.Context
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.widget.TextView

import com.core.kbasekit.R

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

class CenteredToolbar : Toolbar {

    private var titleView: TextView? = null

    constructor(context: Context) : super(context, null) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        titleView!!.x = ((width - titleView!!.width) / 2).toFloat()
    }

    override fun setTitle(title: CharSequence) {
        titleView!!.text = title
    }

    private fun init() {
        titleView = TextView(context)
        titleView!!.setTextAppearance(context, R.style.ToolbarTitleText)
        titleView!!.textSize = 16f
        addView(titleView, Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT))
    }
}
