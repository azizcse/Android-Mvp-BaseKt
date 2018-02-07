package com.core.kbasekit.data.db.user

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/1/2018 at 4:00 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/1/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

@Dao
interface UserDao {
    @Insert
    fun insert(user : User)

    @Query("Select * from User")
    fun getUsers():Flowable<List<User>>

}