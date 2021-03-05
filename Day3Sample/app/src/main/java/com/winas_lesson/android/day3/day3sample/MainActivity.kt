package com.winas_lesson.android.day3.day3sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day3.day3sample.`interface`.ViewBindable
import com.winas_lesson.android.day3.day3sample.data.model.Content
import com.winas_lesson.android.day3.day3sample.databinding.ActivityMainBinding
import com.winas_lesson.android.day3.day3sample.ui.AbstractActivity
import com.winas_lesson.android.day3.day3sample.ui.CustomUIActivity
import com.winas_lesson.android.day3.day3sample.ui.OtherUIActivity
import com.winas_lesson.android.day3.day3sample.util.showToast
import timber.log.Timber

class MainActivity : AbstractActivity(), ViewBindable {
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
//            val intent = Intent(applicationContext, CustomUIActivity::class.java)
//            val content = Content.create()
//            intent.putExtra(ActivityExtraData.SAMPLE_NUMBER.key, 12345)
//            intent.putExtra(ActivityExtraData.CONTENT.key, content)
//            //startActivity(intent)
//            startActivityForResult(intent, ActivityRequestCode.CUSTOM_UI.code)

            val intent = Intent(applicationContext, OtherUIActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.d("#issue onActivityResult requestCode= $requestCode, resultCode= $resultCode")
        when(resultCode) {
            ActivityResultCode.CUSTOM_UI.code -> {
                (data?.extras?.getInt(ActivityResultData.SAMPLE_NUMBER.key, 0))?.let {
                    showToast("result data number is $it!!")
                }
            }
        }
    }
}