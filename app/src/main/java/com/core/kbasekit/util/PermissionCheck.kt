package com.core.kbasekit.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/27/2017 at 1:49 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/27/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

object PermissionCheck {
    private val PERMISSION_REQUEST_CODE: Int = 100

    fun requestPermission(context: Context, vararg values: String): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true
        }

        var list: ArrayList<String> = arrayListOf()

        for (value: String in values) {
            if (context.checkSelfPermission(value) != PackageManager.PERMISSION_GRANTED) {
                list.add(value)
            }
        }

        if (list.isEmpty()) return true

        (context as Activity).requestPermissions(list.toTypedArray(), PERMISSION_REQUEST_CODE)

        return false;
    }

    private fun requestPermission(context: Context, requestCode: Int, vararg values: String): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true
        }

        var list: ArrayList<String> = arrayListOf()

        for (value: String in values) {
            list.add(value)
        }

        if (list.isEmpty()) return true

        (context as Activity).requestPermissions(list.toTypedArray(), requestCode)

        return false;

    }


}

