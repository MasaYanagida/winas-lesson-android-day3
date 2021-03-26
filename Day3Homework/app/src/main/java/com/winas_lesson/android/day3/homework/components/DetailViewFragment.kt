package com.winas_lesson.android.day3.homework.components

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.TypefaceSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.winas_lesson.android.day3.homework.App
import com.winas_lesson.android.day3.homework.R
import com.winas_lesson.android.day3.homework.`interface`.ViewBindable
import com.winas_lesson.android.day3.homework.data.model.Content
import com.winas_lesson.android.day3.homework.databinding.DetailViewFragmentBinding
import com.winas_lesson.android.day3.homework.util.toColorString

interface DetailViewFragmentListener {
    fun onFavoriteButtonTapped(fragment: DetailViewFragment)
}

class DetailViewFragment : Fragment(), ViewBindable {
    override lateinit var binding: ViewBinding
    var listener: DetailViewFragmentListener? = null

    private val nameTextView: TextView?
        get() = (binding as? DetailViewFragmentBinding)?.nameTextView
    private val brandsTextView: TextView?
        get() = (binding as? DetailViewFragmentBinding)?.brandsTextView
    private val descriptionTextView: TextView?
        get() = (binding as? DetailViewFragmentBinding)?.descriptionTextView
    private val imageView: ImageView?
        get() = (binding as? DetailViewFragmentBinding)?.imageView
    private val button: Button?
        get() = (binding as? DetailViewFragmentBinding)?.button
    var content: Content = Content()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DetailViewFragmentBinding.inflate(inflater, container, false)

        nameTextView?.text = content.name
        var brandIconTexts = mutableListOf<String>()
        content.icons.forEach { icon ->
            val string = getString(
                R.string.brand_text,
                "#${icon.color.toColorString()}",
                getString(icon.resourceId)
            )
            brandIconTexts.add(string)
        }
        val brandIconContent = brandIconTexts.joinToString("<br />")
        val spannedText = SpannableString(Html.fromHtml(brandIconContent))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && spannedText.isNotEmpty()) { // version 28
            // custom font in spannable
            ResourcesCompat.getFont(context ?: App.context, R.font.fa_brands_400)?.let {
                val span = TypefaceSpan(it)
                spannedText.setSpan(span, 0, spannedText.length - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
        brandsTextView?.setText(spannedText, TextView.BufferType.SPANNABLE)
        descriptionTextView?.text = content.description
        imageView?.let {
            Glide.with(this)
                .load(content.imageUrlString)
                .into(it)
        }
        button?.setOnClickListener {
            listener?.onFavoriteButtonTapped(this)
        }
        return binding.root
    }
}
