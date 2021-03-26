package com.winas_lesson.android.day3.homework.components

import android.os.Build
import android.os.Bundle
import android.os.Handler
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
import com.squareup.picasso.Picasso
import com.winas_lesson.android.day3.homework.App
import com.winas_lesson.android.day3.homework.R
import com.winas_lesson.android.day3.homework.`interface`.ViewBindable
import com.winas_lesson.android.day3.homework.data.model.Content
import com.winas_lesson.android.day3.homework.databinding.DetailViewFragmentBinding
import com.winas_lesson.android.day3.homework.util.toColorString
import com.winas_lesson.android.day3.homework.util.showToast
import kotlinx.android.synthetic.main.detail_view_fragment.view.*
import com.winas_lesson.android.day3.homework.helper.BrandIconDrawable

interface DetailViewFragmentListener {
    fun onFavoriteButtonTapped(fragment: DetailViewFragment)
}

class DetailViewFragment : Fragment(), ViewBindable {
    override lateinit var binding: ViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DetailViewFragmentBinding.inflate(inflater, container, false)

        // TODO
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val content = Content.create()
        view.textView_name?.text = content.name
        view.textView_description?.text = content.description
        Handler().postDelayed({
            view.imageView3?.let {
                Picasso.get()
                    .load("http://i.imgur.com/DvpvklR.png")
                    .into(it)
            }
        }, 500L)
        super.onViewCreated(view, savedInstanceState)
        val favoriteButton = view.findViewById<Button>(R.id.button_favorite)
        favoriteButton.setOnClickListener{
            activity?.showToast("お気に入りに登録しました")
        }
    }
}
