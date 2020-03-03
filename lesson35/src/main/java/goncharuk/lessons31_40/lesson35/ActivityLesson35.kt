package goncharuk.lessons31_40.lesson35

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import goncharuk.lessons31_40.lesson35.databinding.ActivityLesson35Binding

class ActivityLesson35 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson35)
        val clMain = findViewById<ConstraintLayout>(R.id.cl_main)
        val binding = DataBindingUtil.bind<ActivityLesson35Binding>(clMain) ?: return
    }
}
