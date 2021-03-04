package com.winas_lesson.android.day3.day3sample.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day3.day3sample.ActivityExtraData
import com.winas_lesson.android.day3.day3sample.ActivityResultCode
import com.winas_lesson.android.day3.day3sample.ActivityResultData
import com.winas_lesson.android.day3.day3sample.R
import com.winas_lesson.android.day3.day3sample.`interface`.ViewBindable
import com.winas_lesson.android.day3.day3sample.data.model.Content
import com.winas_lesson.android.day3.day3sample.databinding.ActivityCustomUiBinding
import com.winas_lesson.android.day3.day3sample.util.showToast
import kotlinx.android.synthetic.main.activity_custom_ui.view.*
import kotlin.properties.Delegates

class CustomUIActivity : AppCompatActivity(), ViewBindable {
    override lateinit var binding: ViewBinding
    private val button: Button?
        get() = (binding as? ActivityCustomUiBinding)?.button
//    private val headerView: SampleHeaderView?
//        get() = (binding as? ActivityCustomUiBinding)?.headerView
    private val nameView: TextView?
        get() = (binding as? ActivityCustomUiBinding)?.nameView
    private val addressView: TextView?
        get() = (binding as? ActivityCustomUiBinding)?.addressView
    private val descriptionView: TextView?
        get() = (binding as? ActivityCustomUiBinding)?.descriptionView

    //private lateinit var fragment: SampleHeaderFragment
    private var content: Content? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomUiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        button?.setOnClickListener {
            finish()
        }
    }
}
