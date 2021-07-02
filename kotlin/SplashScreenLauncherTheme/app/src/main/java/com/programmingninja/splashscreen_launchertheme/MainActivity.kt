package com.programmingninja.splashscreen_launchertheme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.SplashScreenLaunch)
        super.onCreate(savedInstanceState)
    }
}