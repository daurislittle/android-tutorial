package com.programmingninja.fcmpushnotification.receiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;
import androidx.annotation.NonNull;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.programmingninja.fcmpushnotification.MainActivity;
import com.programmingninja.fcmpushnotification.R;

import java.util.Random;

public class FirebaseMessageReceiver extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";



    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null)  {
            super.onMessageReceived(remoteMessage);
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            displayNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        }

    }

    private RemoteViews getNotificationDesign(String header, String body) {
        RemoteViews rv = new RemoteViews(getApplicationContext().getPackageName(), R.layout.activity_notification);
        rv.setTextViewText(R.id.tv_header, header);
        rv.setTextViewText(R.id.tv_body, body);
        rv.setImageViewResource(R.id.iv_notificationImage, R.drawable.ic_launcher_background);

        return rv;
    }

    public void displayNotification(String header, String body) {
        Intent intent = new Intent(this, MainActivity.class);

        String channel_id = "notification_channel";
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder ncb = new NotificationCompat.Builder(getApplicationContext(), channel_id)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true)
                .setContentTitle(header)
                .setContentText(body)
                //.setVibrate(new long[]{1000,1000,1000,1000,1000})
                .setOnlyAlertOnce(true)
                .setContentIntent(pi);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ncb = ncb.setContent(getNotificationDesign(header, body));
        } else {
            ncb = ncb.setContentTitle(header).setContentText(body).setSmallIcon(R.drawable.ic_launcher_background);
        }

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel(channel_id, "New Notification", NotificationManager.IMPORTANCE_HIGH);
            ncb.setChannelId(channel_id);
            nm.createNotificationChannel(nc);
        }

        Notification notification = ncb.build();

        int randomId = new Random().nextInt();
        nm.notify(randomId, notification);

    }
}
