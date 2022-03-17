package com.programmingninja.appnotification

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.programmingninja.appnotification.helper.NotificationService
import com.programmingninja.appnotification.helper.Notifier

class MainActivity : AppCompatActivity() {
    //global variables
    lateinit var notificationTitle: AppCompatEditText
    lateinit var delayTimer: AppCompatEditText
    lateinit var scheduleBtn: AppCompatButton
    lateinit var parent: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun scheduleAlert(view: View){
        notificationTitle =  findViewById(R.id.et_messageTitle)
        delayTimer = findViewById(R.id.et_setTimer)
        parent = findViewById(R.id.rootLayer)

        //val notify = Notifier(this)
        //notify.notificationSend(notificationTitle.text.toString(), "Pardon sir this is the reminder notification requested")

        closeKeyboard()
        val intent = Intent(this, NotificationService::class.java)

        intent.putExtra("title", notificationTitle.text.toString())
        intent.putExtra("content", "Pardon sir this is the reminder notification requested")
        intent.putExtra("delayed", delayTimer.text.toString().toLongOrNull())

        startService(intent)

        Snackbar.make(parent, "Reminder is now set for: ${notificationTitle.text}", Snackbar.LENGTH_LONG).show()

        notificationTitle.text?.clear()
        delayTimer.text?.clear()
    }

    fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}