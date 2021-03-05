package com.winas_lesson.android.day3.day3sample.components

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.winas_lesson.android.day3.day3sample.R
import com.winas_lesson.android.day3.day3sample.`interface`.ViewBindable
import com.winas_lesson.android.day3.day3sample.data.model.Content
import com.winas_lesson.android.day3.day3sample.databinding.SampleHeaderViewBinding
import kotlin.properties.Delegates

interface SampleHeaderViewListener {
    fun onIconTapped(view: SampleHeaderView)
}

class SampleHeaderView : FrameLayout, ViewBindable {
    constructor(context: Context) : super(context) {
        initialize()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val typedAttrs = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Activatable,
            0, 0
        )
        try {
            activeColor = typedAttrs.getColor(R.styleable.Activatable_active_color, activeColor)
            inactiveColor = typedAttrs.getColor(R.styleable.Activatable_inactive_color, inactiveColor)
        } finally {
            typedAttrs.recycle()
        }
        initialize()
    }
    override lateinit var binding: ViewBinding
    private val iconView: ImageView?
        get() = (binding as? SampleHeaderViewBinding)?.iconView
    private val nameTextView: TextView?
        get() = (binding as? SampleHeaderViewBinding)?.nameTextView
    private val addressTextView: TextView?
        get() = (binding as? SampleHeaderViewBinding)?.addressTextView

    var listener: SampleHeaderViewListener? = null
    var content: Content by Delegates.observable(Content(), { _, _, new ->
        iconView?.let {
            Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .into(it)
        }
        nameTextView?.text = content.name
        addressTextView?.text = content.address
    })
    var activeColor: Int = Color.argb(255, 255, 255, 255)
    var inactiveColor: Int = Color.argb(255, 255, 255, 255)
    var isActive: Boolean by Delegates.observable(true, { _, _, new ->
        setBackgroundColor(if (isActive) activeColor else inactiveColor)
    })

    private fun initialize() {
        binding = SampleHeaderViewBinding.inflate(LayoutInflater.from(context), this, true)

        iconView?.setOnClickListener {
            listener?.onIconTapped(this)
        }
    }
}
