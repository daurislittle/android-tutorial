package com.programmingninja.splashscreen_timer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    //setting the timer for the activity
    private val SPLASH_TIMER:Long = 5000 // this equates to seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //fire after timer expires
        Handler().postDelayed({
            //start the main activity
            startActivity(Intent(this,MainActivity::class.java))
        }, SPLASH_TIMER)
    }
}