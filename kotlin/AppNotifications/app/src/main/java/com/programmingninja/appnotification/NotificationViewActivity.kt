package com.programmingninja.appnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class NotificationViewActivity : AppCompatActivity() {
    lateinit var parent : ConstraintLayout
    lateinit var notificationTitle : AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_view)
        parent = findViewById(R.id.rootLayer)
        notificationTitle = findViewById(R.id.tv_notificationMessage)
        notificationTitle.text = intent.getStringExtra("title") ?: ""

        Snackbar.make(parent, "Welcome back ", Snackbar.LENGTH_SHORT).show()
    }
}