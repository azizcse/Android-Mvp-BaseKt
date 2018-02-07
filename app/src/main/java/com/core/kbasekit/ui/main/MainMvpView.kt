package com.core.kbasekit.ui.main

import com.core.kbasekit.data.db.user.User
import com.core.kbasekit.ui.base.MvpView


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/14/2017 at 7:33 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/14/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

interface MainMvpView : MvpView {
    fun showLog(users : List<User>)
    fun finish()
}