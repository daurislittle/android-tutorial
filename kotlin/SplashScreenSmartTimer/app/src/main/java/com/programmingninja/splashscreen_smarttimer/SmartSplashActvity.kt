package com.programmingninja.splashscreen_smarttimer

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat

class SmartSplashActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_splash_actvity)

        val sp = getPreferences(Context.MODE_PRIVATE)
        val firstLaunchPrefKey = "pref_first_launch"

        val splashDuration = when(sp.getBoolean(firstLaunchPrefKey, true)) {
            true -> {
                //
                sp.edit().putBoolean(firstLaunchPrefKey, false).apply()
                5000
            }
            false -> {
                //
                10000
            }
        }

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, splashDuration.toLong())
    }

}