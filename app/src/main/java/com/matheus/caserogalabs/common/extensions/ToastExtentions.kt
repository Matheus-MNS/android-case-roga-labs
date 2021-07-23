package com.matheus.caserogalabs.common.extensions

import android.app.Activity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.matheus.caserogalabs.R

fun Toast.showCustomToast(message: String, activity: Activity?) {

    val layout = activity?.layoutInflater?.inflate(
        R.layout.customer_toast, activity.findViewById(R.id.toastContainer)
    )

    val textView = layout?.findViewById<TextView>(R.id.toastText)
    textView?.text = message

    this.apply {
        setGravity(Gravity.BOTTOM, 0, 40)
        duration = Toast.LENGTH_SHORT
        view = layout
        show()
    }
}