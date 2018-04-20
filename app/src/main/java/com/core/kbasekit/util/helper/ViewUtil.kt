package com.core.kbasekit.util.helper

import android.content.Context
import android.util.TypedValue

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

class ViewUtil {
    companion object {
        private var context: Context? = null

        fun init(context: Context) {
            this.context = context
        }

        fun dpToPx(dp: Int): Int {
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
                    context?.resources?.displayMetrics))
        }
    }
}