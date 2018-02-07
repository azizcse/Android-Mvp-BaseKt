package com.core.kbasekit.data.db.contact

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert



/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/1/2018 at 4:36 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/1/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/
@Dao
interface ContactDao {
    @Insert
    fun insert(contact : Contact)
}