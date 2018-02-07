package com.core.kbasekit.data.db.contact

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/27/2017 at 4:04 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/27/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/
@Entity(tableName = "Contact")
data class Contact(
        @PrimaryKey
        var number : String,
        var callDate : String,
        var callDayTime : String,
        var callDuration : String,
        var callType : String){
        
        @Ignore
        constructor() : this("", "", "", "", "")
}