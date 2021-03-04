package com.winas_lesson.android.day3.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.winas_lesson.android.day3.homework.components.DetailViewFragment
import com.winas_lesson.android.day3.homework.components.DetailViewFragmentListener
import com.winas_lesson.android.day3.homework.data.model.Content
import com.winas_lesson.android.day3.homework.util.showToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = DetailViewFragment()
        fragment.content = Content.create()
        fragment.listener = object : DetailViewFragmentListener {
            override fun onFavoriteButtonTapped(fragment: DetailViewFragment) {
                showToast("onFavoriteButtonTapped!!")
            }
        }
        supportFragmentManager.beginTransaction().add(R.id.header_fragment_container, fragment).commit()
    }
}