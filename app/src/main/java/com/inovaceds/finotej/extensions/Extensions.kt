package com.inovaceds.finotej.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun Context.hideKeyboard(view: View) {
    val inputManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(view.windowToken, 0)
}