package com.core.kbasekit

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDexApplication
import com.core.kbasekit.data.local.DatabaseHelper
import com.core.kbasekit.util.helper.Toaster
import com.core.kbasekit.util.helper.ViewUtil
import dagger.internal.DaggerCollections


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/26/2017 at 5:30 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/26/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/
class BaseApp : MultiDexApplication() {

    companion object {
        operator fun get(context: Context): BaseApp {
            return context.applicationContext as BaseApp
        }
    }
    override fun onCreate() {
        super.onCreate()
       // mApplicationComponent?.inject(this)
        Toaster.init(this)
        ViewUtil.init(this)
        DatabaseHelper.getInstance(applicationContext)
    }
}