package com.winas_lesson.android.day3.homework.components

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.TypefaceSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day3.homework.BrandIcon
import com.winas_lesson.android.day3.homework.R
import com.winas_lesson.android.day3.homework.R.string
import com.winas_lesson.android.day3.homework.R.string.*
import com.winas_lesson.android.day3.homework.`interface`.ViewBindable
import com.winas_lesson.android.day3.homework.databinding.TitleViewBinding
import com.winas_lesson.android.day3.homework.util.toColorString

class TitleView : FrameLayout, ViewBindable {
    constructor(context: Context) : super(context) {
        initialize()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize()
    }
    private val textViewBrand: TextView?
        get() = (binding as? TitleViewBinding)?.textViewBrand

    override lateinit var binding: ViewBinding
    private fun initialize() {
        binding = TitleViewBinding.inflate(LayoutInflater.from(context), this, true)
    }
    private fun onCreate(savedInstanceState: Bundle?) {
        val icon = BrandIcon.LINE
        val content = resources.getString(
            brand_title,
            "#${icon.color.toColorString()}",
            resources.getString(icon.resourceId),
            icon.title
        )
        val spannedText = SpannableString(Html.fromHtml(content))
        textViewBrand?.setText(spannedText, TextView.BufferType.SPANNABLE)


    }
}
