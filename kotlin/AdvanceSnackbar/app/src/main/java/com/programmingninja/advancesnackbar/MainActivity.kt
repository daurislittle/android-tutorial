package com.programmingninja.advancesnackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.programmingninja.advancesnackbar.snackbar.CustomSnackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_catch_em).setOnClickListener {
            CustomSnackbar.make(it).show()
        }
    }
}