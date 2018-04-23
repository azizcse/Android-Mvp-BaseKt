package com.core.kbasekit.util.helper

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/* ****************************************************************************
* * Created by:
* * Name : Md. Imran Hossain
* * Date : 4/23/2018
* * Email : hossain.imran.cse11@gmail.com
* *
* * Last Edited by : Md. Imran Hossain on 4/23/2018
* *
* * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
* ****************************************************************************
*/

object SharedPref {
    private var preferences: SharedPreferences? = null

    fun init(context: Context) {
        if (preferences == null) {
            preferences = PreferenceManager.getDefaultSharedPreferences(context)
        }
    }

    fun write(key: String, value: String): Boolean {
        val editor = preferences!!.edit()

        editor.putString(key, value)

        return editor.commit()
    }

    fun write(key: String, value: Boolean): Boolean {
        val editor = preferences!!.edit()

        editor.putBoolean(key, value)

        return editor.commit()
    }

    fun write(key: String, value: Int): Boolean {
        val editor = preferences!!.edit()

        editor.putInt(key, value)

        return editor.commit()
    }

    fun write(key: String, value: Long): Boolean {
        val editor = preferences!!.edit()

        editor.putLong(key, value)

        return editor.commit()
    }

    fun read(key: String): String {
        return preferences!!.getString(key, "")
    }

    fun readLong(key: String): Long {
        return preferences!!.getLong(key, 0)
    }

    fun readInt(key: String): Int {
        return preferences!!.getInt(key, 0)
    }

    fun readBoolean(key: String): Boolean {
        return preferences!!.getBoolean(key, false)
    }

    fun readBooleanDefaultTrue(key: String): Boolean {
        return preferences!!.getBoolean(key, true)
    }

    operator fun contains(key: String): Boolean {
        return preferences!!.contains(key)
    }

}