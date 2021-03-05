package com.winas_lesson.android.day3.day3sample.ui

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.TypefaceSpan
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import com.squareup.picasso.Picasso
import com.winas_lesson.android.day3.day3sample.BrandIcon
import com.winas_lesson.android.day3.day3sample.R
import com.winas_lesson.android.day3.day3sample.`interface`.ViewBindable
import com.winas_lesson.android.day3.day3sample.databinding.ActivityOtherUiBinding
import com.winas_lesson.android.day3.day3sample.helper.BrandIconDrawable
import com.winas_lesson.android.day3.day3sample.util.*

class OtherUIActivity : AppCompatActivity(), ViewBindable {
    override lateinit var binding: ViewBinding
    private val button: Button?
        get() = (binding as? ActivityOtherUiBinding)?.button
    private val textView: TextView?
        get() = (binding as? ActivityOtherUiBinding)?.textView
    private val textView2: TextView?
        get() = (binding as? ActivityOtherUiBinding)?.textView2
    private val imageView: ImageView?
        get() = (binding as? ActivityOtherUiBinding)?.imageView
    private val imageView2: ImageView?
        get() = (binding as? ActivityOtherUiBinding)?.imageView2
    private val imageView3: ImageView?
        get() = (binding as? ActivityOtherUiBinding)?.imageView3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherUiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // ① fetch image from res/drawable
        // (1) set resource from resource ID
        button?.setBackgroundResource(R.drawable.button_common)

        // (2) Drawable
        button?.setCompoundDrawables(
            loadDrawable(R.drawable.account_id_icon, this),
            null,
            null,
            null
        )

        // (3) set bitmap generated from drawable
        //imageView?.setImageDrawable(loadDrawable(R.drawable.sample, this))
        loadDrawable(R.drawable.sample, this)?.let {
            imageView?.setImageBitmap(it.getBitmap())
        }

        // ② fetch image from file
        imageView2?.setImageBitmap(getBitmapFromAssets("sample.jpg"))

        // ③ set image from icon font
        textView?.setCompoundDrawables(
            BrandIconDrawable.create(this, BrandIcon.TWITTER, 20.pixel),
            null,
            null,
            null
        )

        // ④ サーバから取得
        Handler().postDelayed({
            imageView3?.let {
                Picasso.get()
                    .load("http://i.imgur.com/DvpvklR.png")
                    .into(it)
            }
        }, 500L)

        val icon = BrandIcon.TWITTER
        val content = resources.getString(
            R.string.sample_html,
            "#${icon.color.toColorString()}",
            resources.getString(icon.resourceId),
            icon.title,
            icon.url
        )
        val spannedText = SpannableString(Html.fromHtml(content))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) { // version 28
            // custom font in spannable
            ResourcesCompat.getFont(this, R.font.fa_brands_400)?.let {
                val span = TypefaceSpan(it)
                spannedText.setSpan(span, 0, spannedText.length - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
        textView2?.setText(spannedText, TextView.BufferType.SPANNABLE)
        textView2?.setLinkTextColor(icon.color/*Color.parseColor("#${icon.color.toColorString()}")*/)
        textView2?.convertLink()
    }
}