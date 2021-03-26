package com.winas_lesson.android.day3.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.winas_lesson.android.day3.homework.components.DetailViewFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO : add custom fragment
        val firstFragment = DetailViewFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.header_fragment_container, firstFragment)
        fragmentTransaction.commit()
    }
}