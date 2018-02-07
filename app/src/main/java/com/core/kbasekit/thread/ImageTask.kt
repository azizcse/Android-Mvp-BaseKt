package com.core.kbasekit.thread

import android.os.AsyncTask


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/4/2018 at 11:37 AM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/4/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

class ImageTask : AsyncTask<Void, Void, Void>() {
    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
    }
    override fun doInBackground(vararg params: Void?): Void {
        return null!!
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
    }
}