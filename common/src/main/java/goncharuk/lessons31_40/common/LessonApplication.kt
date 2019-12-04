package goncharuk.lessons31_40.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class LessonApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}