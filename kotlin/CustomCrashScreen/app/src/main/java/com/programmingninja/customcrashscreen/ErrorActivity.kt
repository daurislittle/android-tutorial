package com.programmingninja.customcrashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.ereza.customactivityoncrash.CustomActivityOnCrash
import kotlinx.android.synthetic.main.activity_error.*

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        val config = CustomActivityOnCrash.getConfigFromIntent(intent)

        if (config == null) {
            finish()
            return
        }

        if (config!!.isShowRestartButton && config.restartActivityClass != null) {
            btn_reboot.text = "Restart App"
            btn_reboot.setOnClickListener {
                CustomActivityOnCrash.restartApplication(this, config!!)
            }
        } else {
            btn_reboot.text = "Close App"
            btn_reboot.setOnClickListener {
                CustomActivityOnCrash.closeApplication(this, config!!)
            }
        }
    }
}