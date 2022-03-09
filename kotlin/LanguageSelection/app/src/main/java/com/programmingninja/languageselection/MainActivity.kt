package com.programmingninja.languageselection

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.intellij.lang.annotations.Language
import java.security.AccessControlContext
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        val config = context.resources.configuration

        Locale.setDefault(locale)
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}