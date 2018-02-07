package com.core.kbasekit.thread

import java.util.concurrent.LinkedBlockingDeque


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/19/2018 at 4:12 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/19/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

class DispatchQueue<T> : LinkedBlockingDeque<T>() {

    fun insertFirst(t: T): Boolean {
        while (true) {
            try {
                super.putFirst(t)
                return true
            } catch (e: InterruptedException) {
            }
        }
    }

    fun insertLast(t: T) {
        while (true) {
            super.putLast(t)
            return
        }
    }

    fun selectFirst(): T {
        return super.getFirst()
    }
}