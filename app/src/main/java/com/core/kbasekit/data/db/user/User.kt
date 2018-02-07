package com.core.kbasekit.data.db.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/14/2017 at 7:37 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/14/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

@Entity(tableName = "User")
data class User(
        @PrimaryKey
        var id : String,
        var name : String,
        var age : Int){
        @Ignore
        constructor():this("","",0)
  }