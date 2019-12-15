package ali.husni.alapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //tambahkan jeda intent ke RegisterActivity
        Handler().postDelayed({
            finish()
            startActivity(Intent(this@SplashScreenActivity, RegisterActivity::class.java))
        },3000)
    }
}
