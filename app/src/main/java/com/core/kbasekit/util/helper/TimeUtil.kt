package com.core.kbasekit.util.helper

import java.util.*

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
object TimeUtil {
    private val SECOND_MILLIS = 1000
    private val MINUTE_MILLIS = 60 * SECOND_MILLIS
    private val HOUR_MILLIS = 60 * MINUTE_MILLIS
    private val DAY_MILLIS = 24 * HOUR_MILLIS

    fun getCurrentTime(): Long {
        val calendar = Calendar.getInstance()
        return calendar.timeInMillis
    }

    fun getTimeAgo(time: Long): String {
        var time = time
        if (time < 1000000000000L) {
            time *= 1000
        }

        val now = getCurrentTime()
        if (time > now || time <= 0) {
            return "In the future"
        }

        val diff = now - time
        return if (diff < MINUTE_MILLIS) {
            return "Just now"
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "A minute ago"
        } else if (diff < 50 * MINUTE_MILLIS) {
            return (diff / MINUTE_MILLIS).toString() + " minutes ago"
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "An hour ago"
        } else if (diff < 24 * HOUR_MILLIS) {
            return (diff / HOUR_MILLIS).toString() + " hours ago"
        } else if (diff < 48 * HOUR_MILLIS) {
            return "Yesterday"
        } else {
            return (diff / DAY_MILLIS).toString() + " days ago"
        }
    }
}