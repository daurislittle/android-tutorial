package com.programmingninja.advancesnackbar.controller

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout

internal fun View?.findParent(): ViewGroup? {

    var view = this
    var fallback: ViewGroup? = null

    do {
        if (view is CoordinatorLayout) {
            //the Coordinator layout has been found
            return view
        } else if (view is FrameLayout) {
            if (view.id == android.R.id.content) {
                //coordinator layout not found so we need to use the appropriate hierarchy
                return view
            } else {
                //if no view assign the fallback
                fallback = view
            }
        }

        if (view != null) {
            //will continue to search for the view
            val parent = view.parent
            view = if (parent is View) parent else null
        }
    } while (view != null)

    return fallback
}