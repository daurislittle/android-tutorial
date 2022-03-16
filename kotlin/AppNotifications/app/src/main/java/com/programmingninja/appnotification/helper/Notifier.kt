package com.programmingninja.appnotification.helper

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.programmingninja.appnotification.R

class Notifier(val context: Context) {
    val channelIdName = "PokemonReminder"

    init {
        notificationChannelCreate()
    }
    private fun notificationChannelCreate() {

        //oreo require channel id to create notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val cName = channelIdName
            val cDescription = "AppleDes"
            val cImportance = NotificationManager.IMPORTANCE_DEFAULT

            val setChannel = NotificationChannel(cName, cName, cImportance).apply {
                description = cDescription
            }
             val nManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nManager.createNotificationChannel(setChannel)
        }
    }

    private fun notificationCreate(title: String, content: String) : Notification {

        val nBuilder = NotificationCompat.Builder(context, channelIdName)
        nBuilder.setSmallIcon(R.mipmap.ic_launcher_round)
        nBuilder.setContentTitle(title)
        nBuilder.setContentText(content)
        nBuilder.priority = NotificationCompat.PRIORITY_DEFAULT

        return nBuilder.build()
    }

    fun notificationSend(title: String, content: String) {
        val createNotification = notificationCreate(title, content)

        with(NotificationManagerCompat.from(context)) {
            val nIdentifier = title.hashCode()
            //notify("", 1800, createNotification)
            notify(1800, createNotification)
        }
    }
}