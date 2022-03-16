package com.programmingninja.appnotification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        val intent = Intent(this, NotificationService::class.java)

        intent.putExtra("title", notificationTitle.text)
        intent.putExtra("content", "Pardon sir this is the reminder notification requested")
        intent.putExtra("delayed", delayTimer.text)

        startService(intent)

        Snackbar.make(parent, "Reminder is now set for: ${notificationTitle.text}", Snackbar.LENGTH_LONG).show()

        notificationTitle.text?.clear()
        delayTimer.text?.clear()
    }
}