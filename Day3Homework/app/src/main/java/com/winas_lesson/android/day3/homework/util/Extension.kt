package com.winas_lesson.android.day3.homework.util

import android.app.Activity
import android.widget.Toast

fun Int.toColorString(): String? {
    var red = Integer.toHexString(this.shr(16) and 0xFF)
    if (red.length == 1) {
        red = "0${red}"
    }
    var green = Integer.toHexString(this.shr(8) and 0xFF)
    if (green.length == 1) {
        green = "0${green}"
    }
    var blue = Integer.toHexString(this and 0xFF)
    if (blue.length == 1) {
        blue = "0${blue}"
    }
    return "${red}${green}${blue}"
}

fun Activity.showToast(text: String) {
    val toast = Toast.makeText(this, text, Toast.LENGTH_LONG)
    toast.show()
}
