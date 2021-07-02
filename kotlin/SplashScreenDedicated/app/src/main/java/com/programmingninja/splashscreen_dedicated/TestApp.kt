package com.programmingninja.splashscreen_dedicated

import android.app.Application
import android.os.SystemClock

class TestApp : Application() {

    override fun onCreate() {
        super.onCreate()

        SystemClock.sleep(5000)
    }
}