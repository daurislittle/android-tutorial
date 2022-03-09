package com.programmingninja.languageselection.helper

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import androidx.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity: AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun attachBaseContext(c: Context) {

        //
        val localeToSwitchTo = PreferenceManager(c)
        val localeUpdateContext: ContextWrapper = ContextUtils.updateLocale(c, localeToSwitchTo)
        super.attachBaseContext(localeUpdateContext)
    }
}