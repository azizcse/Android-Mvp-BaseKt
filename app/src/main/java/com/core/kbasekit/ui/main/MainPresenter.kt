package com.core.kbasekit.ui.main

import android.Manifest
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.core.kbasekit.ui.base.BasePresenter
import android.provider.CallLog
import android.system.Os
import com.core.kbasekit.data.db.AppDataBase
import com.core.kbasekit.data.db.DatabaseHelper
import com.core.kbasekit.data.db.contact.Contact
import com.core.kbasekit.data.db.user.User
import com.core.kbasekit.data.db.user.UserDao
import com.core.kbasekit.util.LogKit
import com.core.kbasekit.util.PermissionCheck
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/14/2017 at 7:32 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/14/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

class MainPresenter : BasePresenter<MainMvpView> {
    lateinit var context: Context
    lateinit var userDao: UserDao

    constructor(context: Context) {
        this.context = context
        initUserDb(context)
    }

    fun initUserDb(context: Context) {
        Thread(Runnable {
            run {
                userDao = DatabaseHelper.getInstance(context).provideUserDao()
                getMvpView()?.finish()
            }
        }).start()

    }

    fun insertUser() {
        Thread(Runnable {
            run {
                val user = User(UUID.randomUUID().toString(), "Aziz", 27)
                val user1 = User(UUID.randomUUID().toString(), "Azim", 32)
                val user2 = User(UUID.randomUUID().toString(), "Paik", 34)

                userDao.insert(user)
                userDao.insert(user1)
                userDao.insert(user2)


            }
        }).start()
       // getUsers()
    }

    fun getUsers(){
        getDisposable()?.add(userDao.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError))


    }

    private fun handleResponse(androidList: List<User>) {
        LogKit.v("User_value", "List size = ${androidList.size}")
        getMvpView()?.showLog(androidList)
    }

    private fun handleError(error: Throwable) {
    }

    fun loadData() {
        Thread(Runnable {
            kotlin.run {
                Log.e("User_value", "message 1")
                Thread.sleep(1000)
                Log.e("User_value", "message 2")

                //getMvpView()!!.showLog()
            }
        }).start()
        Log.e("User_value", "message 0")
    }


    var thread: Thread = Thread() {
        Log.e("User_value", "message 1")
        Thread.sleep(1000)
        Log.e("User_value", "message 2")
    }


    fun getCallDetails(context: Context): List<Contact> {

        val contactList: ArrayList<Contact> = arrayListOf()

        if (PermissionCheck.requestPermission(context, Manifest.permission.READ_CALL_LOG)) {
            val cursor = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, CallLog.Calls.DATE + " DESC")
            val number = cursor.getColumnIndex(CallLog.Calls.NUMBER)
            val type = cursor.getColumnIndex(CallLog.Calls.TYPE)
            val date = cursor.getColumnIndex(CallLog.Calls.DATE)
            val duration = cursor.getColumnIndex(CallLog.Calls.DURATION)
            val nameIindex = cursor.getColumnIndex(CallLog.Calls.CACHED_NAME)
            while (cursor.moveToNext()) {
                //val name = cursor.getString(nameIindex);
                val phNumber = cursor.getString(number)
                val callType = cursor.getString(type)
                val callDate = cursor.getString(date)
                val callDayTime = Date(java.lang.Long.valueOf(callDate))
                val callDuration = cursor.getString(duration)
                var dir: String? = null
                val dircode = Integer.parseInt(callType)
                when (dircode) {
                    CallLog.Calls.OUTGOING_TYPE -> dir = "OUTGOING"
                    CallLog.Calls.INCOMING_TYPE -> dir = "INCOMING"

                    CallLog.Calls.MISSED_TYPE -> dir = "MISSED"
                }

                val contact = Contact(phNumber, callDate, callDayTime.toString(), callDuration, dir!!)
                 contactList.add(contact)
            }
            cursor.close()
        }
        return contactList
    }

}

