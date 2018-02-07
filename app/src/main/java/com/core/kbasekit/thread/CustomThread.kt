package com.core.kbasekit.thread

import android.util.Log


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/15/2017 at 7:02 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/15/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

class CustomThread : Runnable {
    var isRunning : Boolean = false
    var thread : Thread? = null

    init {
        thread = Thread(this)
    }

    fun start(){
        if(isRunning) return
        isRunning = true
        thread?.start()
        Log.e("Log_thread","Thread start");
    }

    fun stopped(){
        if(!isRunning) return
        thread?.isInterrupted
        isRunning = false;
        Log.e("Log_thread","Thread stop");
    }

    override fun run() {
        while (isRunning){
            Thread.sleep(1000);
            Log.e("Log_thread","log inside thread");
        }
    }
}