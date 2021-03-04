package com.winas_lesson.android.day3.day3sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day3.day3sample.`interface`.ViewBindable
import com.winas_lesson.android.day3.day3sample.data.model.Content
import com.winas_lesson.android.day3.day3sample.databinding.ActivityMainBinding
import com.winas_lesson.android.day3.day3sample.ui.CustomUIActivity
import com.winas_lesson.android.day3.day3sample.ui.OtherUIActivity
import com.winas_lesson.android.day3.day3sample.util.showToast
import timber.log.Timber

class MainActivity : AppCompatActivity(), ViewBindable {
    override lateinit var binding: ViewBinding
    private val button: Button?
        get() = (binding as? ActivityMainBinding)?.button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)

        button?.setOnClickListener {
            val intent = Intent(applicationContext, CustomUIActivity::class.java)
            startActivity(intent)

//            val intent = Intent(applicationContext, OtherUIActivity::class.java)
//            startActivity(intent)
        }
    }
}