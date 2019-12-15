package ali.husni.alapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_success.*
import org.jetbrains.anko.*

class SuccessActivity : AppCompatActivity() {

    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        sharedPrefManager = SharedPrefManager(this)
    }
    override fun onClick(v: View?) {
        when(v){
            sign_out_button->{
                alert("apakah anda ngin logout") {
                    noButton {
                        toast("Anda tifak jadi keluar")
                        startActivity(intentFor<LoginActivity>())
                        finish()
                    }
                    yesButton {
                        if (sharedPrefManager.sPSudahLogin) {
                            (
                                    sharedPrefManager.saveSPBoolean(
                                        sharedPrefManager.SP_SUDAH_LOGIN,
                                        false
                                    )
                                            startActivity(
                                            Intent(
                                                this@SuccessActivity,
                                                LoginActivity::class.java
                                            )
                                                .addFlags(
                                                    Intent.FLAG_ACTIVITY_CLEAR_TOP or
                                                            Intent.FLAG_ACTIVITY_NEW_TASK
                                                )
                                            )
                        }
                            super.onBackPressed()
                        }else
                            {toast("ANDA GAGAL KELUAR")}
                        }
                    }
                }.show()z
            }
    }
    companion object{
        fun getLauchIntent(from: Context)= Intent(from, SuccessActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}
