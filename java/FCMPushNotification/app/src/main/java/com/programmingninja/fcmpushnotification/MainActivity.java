package com.programmingninja.fcmpushnotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.messaging.FirebaseMessaging;
import com.programmingninja.fcmpushnotification.receiver.FirebaseMessageReceiver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent backgroundService = new Intent(this, FirebaseMessageReceiver.class);
        startService(backgroundService);
        FirebaseMessaging.getInstance().subscribeToTopic("testPushNotification").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                String msg = "done";
                if (!task.isSuccessful()) {
                    msg = "failed";
                }
                Log.d(msg, msg);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                //Snackbar.make(this, msg, Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}