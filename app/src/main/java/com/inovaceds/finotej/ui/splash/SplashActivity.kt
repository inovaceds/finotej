package com.inovaceds.finotej.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.inovaceds.finotej.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        activity_splash_logo_image.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in))

        Handler(mainLooper).postDelayed({startDescriptionActivity()},1500)
    }

    private fun startDescriptionActivity(){

    }
}
