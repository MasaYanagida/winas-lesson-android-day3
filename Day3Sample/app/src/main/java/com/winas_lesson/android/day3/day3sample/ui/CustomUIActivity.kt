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
import com.winas_lesson.android.day3.day3sample.components.SampleHeaderFragment
import com.winas_lesson.android.day3.day3sample.components.SampleHeaderFragmentListener
import com.winas_lesson.android.day3.day3sample.components.SampleHeaderView
import com.winas_lesson.android.day3.day3sample.components.SampleHeaderViewListener
import com.winas_lesson.android.day3.day3sample.data.model.Content
import com.winas_lesson.android.day3.day3sample.databinding.ActivityCustomUiBinding
import com.winas_lesson.android.day3.day3sample.util.showToast
import kotlinx.android.synthetic.main.activity_custom_ui.view.*
import kotlin.properties.Delegates

class CustomUIActivity : AppCompatActivity(), ViewBindable {
    override lateinit var binding: ViewBinding
    private val button: Button?
        get() = (binding as? ActivityCustomUiBinding)?.button
    private val headerView: SampleHeaderView?
        get() = (binding as? ActivityCustomUiBinding)?.headerView
    private val nameView: TextView?
        get() = (binding as? ActivityCustomUiBinding)?.nameView
    private val addressView: TextView?
        get() = (binding as? ActivityCustomUiBinding)?.addressView
    private val descriptionView: TextView?
        get() = (binding as? ActivityCustomUiBinding)?.descriptionView

    private lateinit var fragment: SampleHeaderFragment
    private var content: Content? = null
//    private var content: Content by Delegates.observable(Content(), { _, _, new ->
//        nameView?.text = new.name
//        addressView?.text = new.address
//        descriptionView?.text = new.description
//    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomUiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        content = intent.getParcelableExtra(ActivityExtraData.CONTENT.key) as? Content
//        (intent.getParcelableExtra(ActivityExtraData.CONTENT.key) as? Content)?.let {
//            content = it
//        }

        headerView?.content = content ?: Content.create()
        headerView?.isActive = true
        headerView?.listener = object : SampleHeaderViewListener {
            override fun onIconTapped(view: SampleHeaderView) {
                showToast("SampleHeaderView IconTapped!!")
            }
        }
        Handler().postDelayed({
            headerView?.isActive = false
        }, 3000L)

        fragment = SampleHeaderFragment()
        fragment.content = content ?: Content.create()
        fragment.activeColor = ResourcesCompat.getColor(resources, R.color.winasLightBlue, null)
        fragment.inactiveColor = Color.WHITE
        fragment.isActive = true
        fragment.listener = object : SampleHeaderFragmentListener {
            override fun onIconTapped(view: SampleHeaderFragment) {
                showToast("SampleHeaderFragment IconTapped!!")
            }
        }
        supportFragmentManager.beginTransaction().add(R.id.header_fragment_container, fragment).commit()
        Handler().postDelayed({
            fragment.isActive = false
        }, 5000L)


        nameView?.text = content?.name
        addressView?.text = content?.address
        descriptionView?.text = content?.description

        button?.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(ActivityResultData.SAMPLE_NUMBER.key, 34567)

            val data = Intent()
            data.putExtras(bundle)
            setResult(ActivityResultCode.CUSTOM_UI.code, data)
            finish()
        }
    }
}
