package goncharuk.lessons31_40.lesson34

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import goncharuk.lessons31_40.lesson34.databinding.ActivityLesson34Binding

class ActivityLesson34 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson34)
        val clMain = findViewById<ConstraintLayout>(R.id.cl_main)
        val binding = DataBindingUtil.bind<ActivityLesson34Binding>(clMain) ?: return
        val dataBase = Lesson34DataBase(this)

        binding.btnAdd.setOnClickListener {
            dataBase.addUser(
                name = binding.etName.text.toString(),
                email = binding.etEmail.text.toString()
            )
        }
        binding.btnRead.setOnClickListener { dataBase.readTable() }
        binding.btnClear.setOnClickListener { dataBase.clearTable() }
    }
}
