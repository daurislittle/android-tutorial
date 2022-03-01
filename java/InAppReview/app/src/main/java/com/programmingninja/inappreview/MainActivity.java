package com.programmingninja.inappreview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;


public class MainActivity extends AppCompatActivity {

    private ReviewManager rm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doInit();
    }

    private void doInit() {
        rm = ReviewManagerFactory.create(this);
        findViewById(R.id.btn_rating).setOnClickListener(view -> showRateApp());
    }

    public void showRateApp() {
        Task<ReviewInfo> request = rm.requestReviewFlow();
        request.addOnCompleteListener(task -> {
           if (task.isSuccessful()) {
               //reviewinfo object
               ReviewInfo ri = task.getResult();

               Task<Void> flow = rm.launchReviewFlow(this, ri);
               flow.addOnCompleteListener(task1 -> {

               });
           } else {
               //
               showRateAppFallbackDialog();
           }
        });
    }

    private void showRateAppFallbackDialog() {
        new MaterialAlertDialogBuilder(this)
                .setTitle(R.string.app_title)
                .setMessage(R.string.app_user_message)
                .setPositiveButton(R.string.app_btn_positive, (dialog, which) -> {

                })
                .setNegativeButton(R.string.app_btn_negative, (dialog, which) -> {

                })
                .setNeutralButton(R.string.app_btn_neutral, (dialog, which) -> {

                }).show();
    }
}