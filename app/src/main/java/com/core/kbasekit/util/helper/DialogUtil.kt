package com.core.kbasekit.util.helper

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.text.Html
import com.core.kbasekit.R

/*
* ****************************************************************************
* * Created by:
* * Name : Md. Imran Hossain
* * Date : 4/23/2018
* * Email : hossain.imran.cse11@gmail.com
* *
* * Purpose: All type of RecyclerView item decoration method
* *
* * Last Edited by : Md. Imran Hossain on 4/23/2018
* *
* * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
* ****************************************************************************
*/

class DialogUtil {
    companion object {
        fun show(context: Context, title: String, message: String,
                 positiveText: String, negativeText: String,
                 dialogListener: DialogListener, flag: Int) {
            try {
                var dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context, R.style.DefaultAlertDialogStyle)
                dialogBuilder.setTitle(Html.fromHtml("<b>" + title + "</b>"))
                dialogBuilder.setMessage(Html.fromHtml("<font color='#757575'>" + message + "</font>"))

                dialogBuilder.setPositiveButton(positiveText!!, DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogListener.onClickPositive(flag)
                })

                dialogBuilder.setNegativeButton(negativeText!!, DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogListener.onClickNegative(flag)
                })

                dialogBuilder.setOnCancelListener(DialogInterface.OnCancelListener { dialogInterface ->
                    dialogListener.onCancel()
                })
                var alertdialog: AlertDialog = dialogBuilder.create()
                alertdialog.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    interface DialogListener {

        fun onClickPositive(flag: Int)

        fun onCancel()

        fun onClickNegative(flag: Int)
    }
}