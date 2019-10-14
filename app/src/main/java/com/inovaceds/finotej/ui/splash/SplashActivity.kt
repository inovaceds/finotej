package com.inovaceds.finotej.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.inovaceds.finotej.R
import com.inovaceds.finotej.ui.description.DescriptionActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        activity_splash_logo_image.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in))

        Handler(mainLooper).postDelayed({ startDescriptionActivity() }, 3000)
    }

    private fun startDescriptionActivity(){
        startActivity<DescriptionActivity>()
        finish()
    }
}
