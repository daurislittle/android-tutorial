package com.programmingninja.gesturecontrol

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.MotionEventCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
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

    //view
    lateinit var view:FrameLayout

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
        view = findViewById<FrameLayout>(R.id.layout_parent)
        qv =  findViewById(R.id.tv_question)
        sv = findViewById(R.id.tv_solution)
        cv = findViewById(R.id.tv_points)
        ab = findViewById(R.id.btn_addition)
        sb = findViewById(R.id.btn_subtraction)

        //assign listeners
        ab.setOnClickListener {
            userAnsw++
            sv.text = "$userAnsw"
        }

        sb.setOnClickListener {
            userAnsw--
            sv.text = "$userAnsw"
        }

        generateQuestion(userAnsw)
        gdc = GestureDetectorCompat(this, GestureControlListener())
    }

    override fun onTouchEvent(evt: MotionEvent): Boolean {
        gdc.onTouchEvent(evt)
        return true
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

    /**
    *
    * */
    inner class GestureControlListener : GestureDetector.SimpleOnGestureListener() {

        override fun onFling(evt1: MotionEvent, evt2: MotionEvent, xVelocity: Float, yVelocity: Float) : Boolean {

            pts -= 75
            questionValue1 = Random.nextInt(15)
            questionValue2 = Random.nextInt(25)
            view.setBackgroundColor(Random.nextInt())
            qv.text = "$questionValue1 + $questionValue2"

            Snackbar.make(view, "Skipped", Snackbar.LENGTH_SHORT).show()
            cv.text = "Current Score: $pts"
            return true
        }



        override fun onDoubleTap(evt: MotionEvent?): Boolean {

            if (userAnsw == questionValue1 + questionValue2) {
                pts = 100*125

                generateQuestion(7)
            } else {
                pts -= 125
                generateQuestion(15)
                view.setBackgroundColor(Color.RED)
                Snackbar.make(view, "Incorrect", Snackbar.LENGTH_SHORT).show()

            }
            cv.text = "Current Score: $pts"
            return true
        }
    }
}