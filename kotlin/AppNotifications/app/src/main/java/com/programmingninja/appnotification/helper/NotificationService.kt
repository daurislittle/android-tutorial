package com.programmingninja.appnotification.helper

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder

class NotificationService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val noteTitle = intent?.getStringExtra("title") ?: ""
        val noteContent = intent?.getStringExtra("content") ?: ""
        val noteDelayed = intent?.getLongExtra("delayed", 0) ?: 0L

        val runnable = Runnable {
            val notify = Notifier(this)
            notify.notificationSend(noteTitle, noteContent)
        }

        Handler().postDelayed(runnable,10000 * noteDelayed)

        return START_STICKY
    }
}