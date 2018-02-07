package com.core.kbasekit.util.helper

import android.content.Context
import android.widget.Toast


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/19/2018 at 5:48 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/19/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

class Toaster {
    companion object {
        private var context : Context? = null
        fun init(context: Context){
            this.context = context
        }

        fun toast(msg : String){
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }
}