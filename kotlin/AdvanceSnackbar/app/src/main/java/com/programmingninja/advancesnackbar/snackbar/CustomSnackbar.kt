package com.programmingninja.advancesnackbar.snackbar

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.programmingninja.advancesnackbar.R
import com.programmingninja.advancesnackbar.controller.findParent
import java.lang.IllegalArgumentException

class CustomSnackbar(parent: ViewGroup, content: CustomSnackbarView) : BaseTransientBottomBar<CustomSnackbar>(parent, content, content) {

    init {
        getView().setBackgroundColor(ContextCompat.getColor(view.context, android.R.color.transparent))
        getView().setPadding(0,0,0,0)
    }

    companion object {
        fun make(view: View) : CustomSnackbar{

            val parent = view.findParent() ?: throw IllegalArgumentException("No suitable parent found from the correct view. Please correct.")

            val customView = LayoutInflater.from(view.context).inflate(R.layout.activity_snackbar, parent, false) as CustomSnackbarView

            return CustomSnackbar(parent, customView)
        }

    }

}