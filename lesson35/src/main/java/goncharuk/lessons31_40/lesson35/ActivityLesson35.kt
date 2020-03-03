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
        val dataBase = Lesson35DataBase(this)
        binding.btnAdd.setOnClickListener {
            dataBase.addUser(
                name = binding.etName.text.toString(),
                email = binding.etEmail.text.toString()
            )
        }
        binding.btnRead.setOnClickListener { dataBase.readTable() }
        binding.btnClear.setOnClickListener { dataBase.clearTable() }
        binding.btnUpdate.setOnClickListener {
            dataBase.updateUser(
                id = binding.etId.text.toString(),
                name = binding.etName.text.toString(),
                email = binding.etEmail.text.toString()
            )
        }
        binding.btnDelete.setOnClickListener { dataBase.deleteUser(binding.etId.text.toString()) }
    }
}
