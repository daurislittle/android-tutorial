package com.programmingninja.appnotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.programmingninja.appnotification.helper.Notifier

class MainActivity : AppCompatActivity() {
    //global variables
    lateinit var notificationTitle: AppCompatEditText
    lateinit var delayTimer: AppCompatEditText
    lateinit var schedule: AppCompatButton
    lateinit var view: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun scheduleAlert(view: View){
        notificationTitle =  findViewById(R.id.et_messageTitle)
        delayTimer = findViewById(R.id.et_setTimer)

        Snackbar.make(view, "Reminder is now set for: $notificationTitle", Snackbar.LENGTH_LONG).show()

        val notify = Notifier(this)
        notify.notificationSend(notificationTitle.text.toString(), "Pardon sir this is the reminder notification requested")
        notificationTitle.text?.clear()
        delayTimer.text?.clear()
    }
}