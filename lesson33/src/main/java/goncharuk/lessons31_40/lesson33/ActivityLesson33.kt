package goncharuk.lessons31_40.lesson33

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import goncharuk.lessons31_40.lesson33.databinding.ActivityLesson33Binding

class ActivityLesson33 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson33)
        val clMain = findViewById<View>(R.id.cl_main)
        val binding = DataBindingUtil.bind<ActivityLesson33Binding>(clMain) ?: return
        val sharedPreferences: SharedPreferences = getSharedPreferences("goncharuk_prefs", Context.MODE_PRIVATE)
        val dataKey = "data in shared pref"

        binding.btnSave.setOnClickListener {
            val inputText = binding.etInput.text.toString()
            sharedPreferences.edit()?.let { editor ->
                editor.putString(dataKey, inputText)
                editor.apply()
            }
        }
        binding.btnLoad.setOnClickListener {
            val savedText = sharedPreferences.getString(dataKey, "") ?: ""
            binding.etInput.setText(savedText)
        }
    }
}
