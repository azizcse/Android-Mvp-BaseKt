package com.core.kbasekit.data.db

import android.arch.persistence.room.Room
import android.content.Context
import com.core.kbasekit.data.db.contact.ContactDao
import com.core.kbasekit.data.db.user.UserDao


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/1/2018 at 4:37 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/1/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/


class DatabaseHelper {
    val appDatabase: AppDataBase

    companion object {

        @JvmStatic
        private var databaseHelper: DatabaseHelper? = null

        @JvmStatic
        fun getInstance(context: Context): DatabaseHelper {
            if (databaseHelper == null) {
                databaseHelper = DatabaseHelper(context)
            }
            return databaseHelper!!
        }
    }

    private constructor(context: Context) {
        appDatabase = AppDataBase.getDatabase(context)!!
    }

    fun provideUserDao(): UserDao {
        return this.appDatabase.getUserDao()
    }

    fun provideContactDao(): ContactDao {
        return this.appDatabase.getContactDao()
    }


}