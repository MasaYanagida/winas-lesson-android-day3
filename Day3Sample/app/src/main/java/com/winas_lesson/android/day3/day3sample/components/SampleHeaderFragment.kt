package com.winas_lesson.android.day3.day3sample.components

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.winas_lesson.android.day3.day3sample.`interface`.ViewBindable
import com.winas_lesson.android.day3.day3sample.data.model.Content
import com.winas_lesson.android.day3.day3sample.databinding.SampleHeaderViewBinding
import kotlin.properties.Delegates

interface SampleHeaderFragmentListener {
    fun onIconTapped(fragment: SampleHeaderFragment)
}

class SampleHeaderFragment : Fragment(), ViewBindable {
    override lateinit var binding: ViewBinding
    var listener: SampleHeaderFragmentListener? = null

    private val iconView: ImageView?
        get() = (binding as? SampleHeaderViewBinding)?.iconView
    private val nameTextView: TextView?
        get() = (binding as? SampleHeaderViewBinding)?.nameTextView
    private val addressTextView: TextView?
        get() = (binding as? SampleHeaderViewBinding)?.addressTextView
    var content: Content = Content()
    var activeColor: Int = Color.argb(255, 255, 255, 255)
    var inactiveColor: Int = Color.argb(255, 255, 255, 255)
    var isActive: Boolean by Delegates.observable(true, { _, _, new ->
        view?.setBackgroundColor(if (isActive) activeColor else inactiveColor)
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = SampleHeaderViewBinding.inflate(inflater, container, false)

        iconView?.setOnClickListener {
            listener?.onIconTapped(this)
        }
        iconView?.let {
            Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .into(it)
        }
        nameTextView?.text = content.name
        addressTextView?.text = content.address
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view?.setBackgroundColor(if (isActive) activeColor else inactiveColor)
    }
}
