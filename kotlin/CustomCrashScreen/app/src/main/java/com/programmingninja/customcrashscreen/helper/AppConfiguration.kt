package com.programmingninja.customcrashscreen.helper

import android.app.Application
import cat.ereza.customactivityoncrash.config.CaocConfig
import com.programmingninja.customcrashscreen.ErrorActivity

class AppConfiguration: Application() {

    override fun onCreate() {
        super.onCreate()
        CaocConfig.Builder.create().trackActivities(true).errorActivity(ErrorActivity::class.java).apply()
    }
}