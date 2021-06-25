package com.programmingninja.advancesnackbar.snackbar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.ImageViewCompat
import com.google.android.material.snackbar.ContentViewCallback
import com.programmingninja.advancesnackbar.R
import java.security.AccessControlContext
import java.util.jar.Attributes

class CustomSnackbarView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout (context, attrs, defStyleAttr), ContentViewCallback {

    private val customImg : ImageView

    init {
        View.inflate(context, R.layout.view_custom_snackbar, this)
        clipToPadding = false
        this.customImg = findViewById(R.id.img_snack)
    }

    override fun animateContentIn(delay: Int, duration: Int) {
        TODO("Not yet implemented")
    }

    override fun animateContentOut(delay: Int, duration: Int) {
        TODO("Not yet implemented")
    }

}