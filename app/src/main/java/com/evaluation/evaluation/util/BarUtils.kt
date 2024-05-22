package com.evaluation.evaluation.util

import android.app.Activity
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat


/**
 * 隐藏ime
 */
fun Activity?.hideIme(currentFocusView: View? = null) {
    if (this == null || window == null) return
    val view = currentFocusView ?: window.decorView
    view.clearFocus()
    val controller = WindowCompat.getInsetsController(window, view)
    controller.hide(WindowInsetsCompat.Type.ime())
}