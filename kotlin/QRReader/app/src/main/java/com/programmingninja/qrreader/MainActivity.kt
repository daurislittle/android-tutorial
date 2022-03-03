package com.programmingninja.qrreader

import android.app.SearchManager
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.google.zxing.integration.android.IntentIntegrator

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val msgTxt:AppCompatTextView = findViewById(R.id.tv_message)
        val imgBtn:AppCompatImageButton = findViewById(R.id.img_btn_qr)

        imgBtn.setOnClickListener {
            val intentIntegrator = IntentIntegrator(this)

            intentIntegrator.setDesiredBarcodeFormats(listOf(IntentIntegrator.QR_CODE))
            intentIntegrator.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val res = IntentIntegrator.parseActivityResult(resultCode,data)

        if (res != null) {
            AlertDialog.Builder(this).setMessage("Would you like to go to ${res.contents}?")
                .setPositiveButton("Accept", DialogInterface.OnClickListener{
                    dialogInterface, i -> val intent = Intent(Intent.ACTION_WEB_SEARCH)
                    intent.putExtra(SearchManager.QUERY, res.contents)
                    startActivity(intent)
                })
                .setNegativeButton("Deny", DialogInterface.OnClickListener{ dialogInterface, i ->  })
                .create()
                .show()
        }
    }
}