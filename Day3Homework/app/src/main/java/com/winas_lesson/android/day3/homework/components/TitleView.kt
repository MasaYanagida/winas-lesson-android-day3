package com.winas_lesson.android.day3.homework.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day3.homework.`interface`.ViewBindable
import com.winas_lesson.android.day3.homework.databinding.TitleViewBinding

class TitleView : FrameLayout, ViewBindable {
    constructor(context: Context) : super(context) {
        initialize()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize()
    }
    override lateinit var binding: ViewBinding
    private fun initialize() {
        binding = TitleViewBinding.inflate(LayoutInflater.from(context), this, true)
    }
}
