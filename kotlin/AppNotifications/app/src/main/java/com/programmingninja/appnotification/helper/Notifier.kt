package com.programmingninja.appnotification.helper

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationManagerCompat

class Notifier(val context: Context) {

    private fun createNotification() {

        //oreo require channel id to create notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val c_Name = ""
            val c_Description = ""
            val c_ID = c_Name
            val c_Importance = NotificationManager.IMPORTANCE_DEFAULT

            val setChannel = NotificationChannel(c_ID, c_Name, c_Importance).apply {
                description = c_Description
            }
             val nManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nManager.createNotificationChannel(setChannel)


        }
    }
}