package com.core.kbasekit.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.core.kbasekit.data.db.contact.Contact
import com.core.kbasekit.data.db.contact.ContactDao
import com.core.kbasekit.data.db.user.User
import com.core.kbasekit.data.db.user.UserDao


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/1/2018 at 4:26 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/1/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/


@Database(version = 1, exportSchema = false, entities = arrayOf(User::class, Contact::class))
abstract class AppDataBase : RoomDatabase() {

    companion object {
        @JvmStatic
        val DB_NAME = "people_db"
        @JvmStatic
        private var dbInstance: AppDataBase? = null

        @JvmStatic
        fun getDatabase(context: Context): AppDataBase? {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder<AppDataBase>(context.applicationContext, AppDataBase::class.java, DB_NAME).build()
            }
            return dbInstance!!
        }

        @JvmStatic
        fun destroyInstance() {
            dbInstance = null
        }
    }

    abstract fun getUserDao(): UserDao
    abstract fun getContactDao(): ContactDao
}