package com.core.kbasekit.util

import android.util.Log


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/27/2017 at 1:24 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/27/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/


object LogKit {

    private val Tag : String = LogKit::class.simpleName!!

    fun v(log : String){
        v(Tag, log)
    }

    fun e(log : String){
       e(Tag, log)
    }

    fun v(tag : String, log :String){
        Log.v(tag, log)
    }

    fun e(tag : String, log :String){
        Log.e(tag, log)
    }
}