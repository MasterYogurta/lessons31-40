package goncharuk.lessons31_40.lesson32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import goncharuk.lessons31_40.lesson32.databinding.ActivityWebViewBinding

class ActivityWebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val clMain = findViewById<View>(R.id.cl_main)
        val binding = DataBindingUtil.bind<ActivityWebViewBinding>(clMain) ?: return
        val intentData = intent.data ?: return

        binding.wvWeb.webViewClient = WebViewClient()
        binding.wvWeb.loadUrl(intentData.toString())
    }
}
