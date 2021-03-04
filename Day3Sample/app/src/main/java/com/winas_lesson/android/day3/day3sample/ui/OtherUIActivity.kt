package com.winas_lesson.android.day3.day3sample.ui

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day3.day3sample.`interface`.ViewBindable
import com.winas_lesson.android.day3.day3sample.databinding.ActivityOtherUiBinding

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

    }
}