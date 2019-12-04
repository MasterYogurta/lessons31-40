package goncharuk.lessons31_40.lesson31

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import goncharuk.lessons31_40.lesson31.databinding.ActivityLesson31Binding

class ActivityLesson31 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson31)
        val clMain = findViewById<ConstraintLayout>(R.id.cl_main)
        val binding = DataBindingUtil.bind<ActivityLesson31Binding>(clMain) ?: return
        binding.btnWeb.setOnClickListener { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/"))) }
        binding.btnMap.setOnClickListener { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("geo:53.885844,27.420606"))) }
        binding.btnCall.setOnClickListener { startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:69420"))) }
    }
}
