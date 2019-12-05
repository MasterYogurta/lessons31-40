package goncharuk.lessons31_40.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import goncharuk.lessons31_40.BR
import goncharuk.lessons31_40.R
import goncharuk.lessons31_40.common.AdapterBaseBinding
import goncharuk.lessons31_40.databinding.MainActivityBinding
import goncharuk.lessons31_40.lesson31.ActivityLesson31
import goncharuk.lessons31_40.lesson32.ActivityLesson32
import goncharuk.lessons31_40.lesson33.ActivityLesson33
import goncharuk.lessons31_40.model.ModelLessonItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val rootView = findViewById<ConstraintLayout>(R.id.cl_main)
        val binding = DataBindingUtil.bind<MainActivityBinding>(rootView) ?: return
        val lessonListAdapter = AdapterBaseBinding<ModelLessonItem>(
                bindingId = BR.lessonItemModel,
                layoutId = R.layout.lesson_list_item,
                onClickListener = { item ->
                    startActivity(Intent(this@MainActivity, item.destination))
                }
        )
        val getString: (resId: Int) -> String = { this@MainActivity.resources.getString(it) }

        binding.rvLessonList.adapter = lessonListAdapter
        binding.rvLessonList.layoutManager =
                LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        val lessonList = ArrayList<ModelLessonItem>().apply {
            add(ModelLessonItem(getString(R.string.tv_lesson31_title), ActivityLesson31::class.java))
            add(ModelLessonItem(getString(R.string.tv_lesson32_title), ActivityLesson32::class.java))
            add(ModelLessonItem(getString(R.string.tv_lesson33_title), ActivityLesson33::class.java))
        }
        lessonListAdapter.updateList(lessonList)
    }
}
