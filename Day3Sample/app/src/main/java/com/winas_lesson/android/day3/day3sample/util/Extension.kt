package com.winas_lesson.android.day3.day3sample.util

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.URLSpan
import android.text.util.Linkify
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.util.LinkifyCompat
import com.winas_lesson.android.day3.day3sample.App
import java.util.regex.Pattern

fun Activity.showToast(text: String) {
    val toast = Toast.makeText(this, text, Toast.LENGTH_LONG)
    toast.show()
}

fun loadDrawable(resId: Int, context: Context): Drawable? {
    return try {
        val opts = BitmapFactory.Options()
        opts.inScaled = false
        val bitmap = BitmapFactory.decodeResource(context.resources, resId, opts)
        val drawable = BitmapDrawable(context.resources, bitmap)
        val bounds = Rect(0, 0, bitmap.width, bitmap.height)
        drawable.bounds = bounds
        drawable
    }
    catch (e: Exception) {
        //e.printStackTrace()
        null
    }
}

fun Drawable.getBitmap(): Bitmap {
    val bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    setBounds(0, 0, canvas.width, canvas.height)
    draw(canvas)
    return bitmap
}

fun Context.getBitmapFromAssets(filename: String): Bitmap? {
    return try {
        val inputStream = assets.open(filename)
        val bitmap = BitmapFactory.decodeStream(inputStream)
        bitmap
    }
    catch (e: Exception) {
        //e.printStackTrace()
        null
    }
}

val Int.dp: Int
    get() {
        val d = App.context.resources.displayMetrics.density
        return (this.toFloat() / d + 0.5).toInt()
    }
val Int.pixel: Int
    get() {
        val d = App.context.resources.displayMetrics.density
        return (this.toFloat() * d + 0.5).toInt()
    }
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

fun TextView.convertLink() {
    val pattern = Pattern.compile("(http://|https://){1}[\\w\\.\\-/:\\#\\?\\=\\&\\;\\%\\~\\+]+",
        Pattern.CASE_INSENSITIVE)
    LinkifyCompat.addLinks(this,  pattern, null, null, null)
    stripUnderlines()
}

fun TextView.stripUnderlines() {
    val span = SpannableString(text)
    val spans = span.getSpans(0, span.length, URLSpan::class.java)
    spans.forEach { sp ->
        val start = span.getSpanStart(sp)
        val end = span.getSpanEnd(sp)
        span.removeSpan(sp)
        span.setSpan(URLSpanNoUnderline(sp.url), start, end, 0)
    }
    this.text = span
}

class URLSpanNoUnderline(val url: String) : URLSpan(url) {
    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.isUnderlineText = false
    }
}
