package com.programmingninja.gesturecontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.GestureDetectorCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    /** Global Variables Start **/
    //gesture
    lateinit var gdc: GestureDetectorCompat

    ///Textviews
    lateinit var qv: AppCompatTextView
    lateinit var sv: AppCompatTextView
    lateinit var cv: AppCompatTextView

    //Buttons
    lateinit var ab: FloatingActionButton
    lateinit var sb: FloatingActionButton

    //integer variables
    var pts = 0
    var userAnsw = 0
    var questionValue1 = 0
    var questionValue2 = 0
    /** Global Variables end **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}