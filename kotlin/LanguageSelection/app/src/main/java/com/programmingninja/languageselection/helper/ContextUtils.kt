package com.programmingninja.languageselection.helper

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import java.util.*

class ContextUtils(base: Context) : ContextWrapper(base) {
    companion object{
        fun updateLocale(context: Context, language:Locale) : ContextWrapper {
            var c = context
            val resources: Resources = c.resources
            val config: Configuration = resources.configuration

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                c = context.createConfigurationContext(config)
            } else {
                resources.updateConfiguration(config, resources.displayMetrics)
            }
            return ContextUtils(c)
        }
    }
}