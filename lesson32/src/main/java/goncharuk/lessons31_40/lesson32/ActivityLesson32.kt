package goncharuk.lessons31_40.lesson32

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import goncharuk.lessons31_40.lesson32.databinding.ActivityLesson32Binding

class ActivityLesson32 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson32)
        val clMain = findViewById<View>(R.id.cl_main)
        val binding = DataBindingUtil.bind<ActivityLesson32Binding>(clMain) ?: return
        val memeUrl = "https://i.kym-cdn.com/photos/images/newsfeed/001/504/739/5c0.jpg"

        binding.btnWeb.setOnClickListener { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(memeUrl))) }
    }
}
