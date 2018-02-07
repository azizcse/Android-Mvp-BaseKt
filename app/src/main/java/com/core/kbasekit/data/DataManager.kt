package com.core.kbasekit.data

import com.core.kbasekit.data.db.user.User


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/1/2018 at 3:00 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/1/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/


interface DataManager {
    fun  getUsers() : List<User>
}