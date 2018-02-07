package com.core.kbasekit.util.helper

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/19/2018 at 3:08 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/19/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/


class HandlerUtil {

    private var foregroundHandler: Handler? = null
    private var handlerThread: HandlerThread? = null
    private var backEndHandler: Handler? = null


    private constructor() {
        foregroundHandler = Handler(Looper.getMainLooper())
        handlerThread = HandlerThread("back_end", Thread.MAX_PRIORITY)
        handlerThread?.start()
        backEndHandler = Handler(handlerThread?.looper)
    }

    companion object {
        private var handlerUtil: HandlerUtil? = null
        fun getInstance(): HandlerUtil {
            if (handlerUtil == null) {
                handlerUtil = HandlerUtil()
            }
            return handlerUtil!!
        }
    }

    fun postForeground(runnable: Runnable, time: Long) {
        foregroundHandler?.postDelayed(runnable, time)
    }

    fun postForeground(runnable: Runnable) {
        foregroundHandler?.post(runnable)
    }

    fun postBackground(runnable : Runnable){
        removeBackground(runnable)
        backEndHandler?.post(runnable)
    }

    fun removeBackground(runnable : Runnable){
        backEndHandler?.removeCallbacks(runnable)
    }

    fun postBackground(runnable : Runnable, time : Long){
        removeBackground(runnable)
        backEndHandler?.postDelayed(runnable, time)
    }

}