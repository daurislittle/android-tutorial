package com.programmingninja.gesturecontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.GestureDetectorCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

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

        //lets do some work
        var view = findViewById<FrameLayout>(R.id.layout_parent)
        qv =  findViewById(R.id.tv_question)
        sv = findViewById(R.id.tv_solution)
        cv = findViewById(R.id.tv_points)
        ab = findViewById(R.id.btn_addition)
        sb = findViewById(R.id.btn_subtraction)

        //assign listeners
        ab.setOnClickListener {
            userAnsw++
            sv.text = userAnsw.toString()
        }

        sb.setOnClickListener {
            userAnsw--
            sv.text = userAnsw.toString()

        }

        generateQuestion(userAnsw)
    }

    //generate question function for user
    fun generateQuestion(num: Int) {
        var randomNum = 0
        randomNum = if (num == 0) 12
        else num

        questionValue1 = Random.nextInt(randomNum)
        questionValue2 = Random.nextInt(randomNum)

        val problem = "$questionValue1 + $questionValue2"
        qv.text = problem
    }
    
}