package com.programmingninja.advancesnackbar.snackbar

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.OvershootInterpolator

import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.ContentViewCallback
import com.programmingninja.advancesnackbar.R

class CustomSnackbarView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout (context, attrs, defStyleAttr), ContentViewCallback {

    private val customImg : AppCompatImageView

    init {
        View.inflate(context, R.layout.view_custom_snackbar, this)
        clipToPadding = false
        this.customImg = findViewById(R.id.img_snack)
    }

    override fun animateContentIn(delay: Int, duration: Int) {
        val scaleX = ObjectAnimator.ofFloat(customImg, View.SCALE_X, 0f, 1f)
        val scaleY = ObjectAnimator.ofFloat(customImg, View.SCALE_Y, 0f, 1f)
        AnimatorSet().apply {
            interpolator = OvershootInterpolator()
            setDuration(500)
            playTogether(scaleX,scaleY)
        }.start()

    }

    override fun animateContentOut(delay: Int, duration: Int) {
        TODO("Not yet implemented")
    }

}