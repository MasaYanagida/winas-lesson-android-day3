package com.winas_lesson.android.day3.homework.components

import android.content.Context
import android.os.Build
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
import com.winas_lesson.android.day3.homework.`interface`.ViewBindable
import com.winas_lesson.android.day3.homework.databinding.TitleViewBinding
import com.winas_lesson.android.day3.homework.util.toColorString
import kotlin.properties.Delegates

class TitleView : FrameLayout, ViewBindable {
    constructor(context: Context) : super(context) {
        initialize()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize()
        val typedAttrs = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Customisable,
            0, 0
        )
        try {
            val iconKey = typedAttrs.getInt(R.styleable.Customisable_brand_icon, 1)
            icon = BrandIcon.values().find { it.key == iconKey } ?: BrandIcon.TWITTER
        } finally {
            typedAttrs.recycle()
        }
    }
    override lateinit var binding: ViewBinding
    var icon: BrandIcon by Delegates.observable(BrandIcon.TWITTER, { _, _, new ->
        val content = resources.getString(
            R.string.brand_title,
            "#${icon.color.toColorString()}",
            resources.getString(icon.resourceId),
            icon.title
        )
        val spannedText = SpannableString(Html.fromHtml(content))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) { // version 28
            // custom font in spannable
            ResourcesCompat.getFont(context, R.font.fa_brands_400)?.let {
                val span = TypefaceSpan(it)
                spannedText.setSpan(span, 0, spannedText.length - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
        textView?.setText(spannedText, TextView.BufferType.SPANNABLE)
    })
    private val textView: TextView?
        get() = (binding as? TitleViewBinding)?.textView

    private fun initialize() {
        binding = TitleViewBinding.inflate(LayoutInflater.from(context), this, true)
    }
}
