package com.core.kbasekit.ui.main

import android.content.Context
import android.util.Log
import com.core.kbasekit.ui.base.BasePresenter
import com.core.kbasekit.data.local.DatabaseHelper
import com.core.kbasekit.data.db.user.User
import com.core.kbasekit.data.db.user.UserDao
import com.core.kbasekit.util.LogKit
import com.core.kbasekit.util.helper.TimeUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
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
    var list: ArrayList<User> = arrayListOf()

    constructor(context: Context) {
        this.context = context
        initUserDb(context)
    }

    fun initUserDb(context: Context) {
        Thread(Runnable {
            run {
                userDao = DatabaseHelper.getInstance(context).provideUserDao()
                getMvpView()?.onDbPrepare()
            }
        }).start()

    }

    fun insertUser() {
        Thread(Runnable {
            run {
                val user = User(UUID.randomUUID().toString(), "Aziz", TimeUtil.getCurrentTime())
                userDao.insert(user)
            }
        }).start()
    }


    /**
     * Load data by Rx
     */
    fun getUsers() {
        getDisposable()?.add(userDao.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError))
    }

    private fun handleResponse(androidList: List<User>) {
        LogKit.v("User_value", "List size = ${androidList.size}")
        getMvpView()?.onUserFound(androidList)
    }

    private fun handleError(error: Throwable) {
    }


    fun deleteUsers(users: List<User>) {
        Thread(Runnable {
            userDao.delete(users)
        }).start()
    }


    private fun delete() {
        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    private fun getObservable(): Observable<Boolean> {
        return Observable.just(true).ambWith {

        }
    }


/*
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
    }*/

    fun loadData() {
        Thread(Runnable {
            kotlin.run {
                Log.e("User_value", "message 1")
                Thread.sleep(1000)
                Log.e("User_value", "message 2")

                //getMvpView()!!.onUserFound()
            }
        }).start()
        Log.e("User_value", "message 0")
    }


    var thread: Thread = Thread() {
        Log.e("User_value", "message 1")
        Thread.sleep(1000)
        Log.e("User_value", "message 2")
    }


}

