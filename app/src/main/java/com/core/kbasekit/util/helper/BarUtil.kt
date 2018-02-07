package com.core.kbasekit.util.helper

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/19/2018 at 3:49 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/19/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

object BarUtil {

    fun setActionBarColor(activity: AppCompatActivity, colorId: Int){
        if (activity != null && colorId > 0) {
            val actionBar = activity.getSupportActionBar()
            if (actionBar != null) {
                actionBar!!.setBackgroundDrawable(ColorDrawable(activity.getResources().getColor(colorId)))
            }
        }
    }

    fun setStatusBarColor(activity : AppCompatActivity, colorId : Int){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.getWindow()
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(getColor(activity, colorId))
        }
    }

    fun getColor(context: Context, colorId: Int): Int {
        return ContextCompat.getColor(context, colorId)
    }

}