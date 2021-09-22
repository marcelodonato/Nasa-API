package com.example.nasa_api.presentation.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.nasa_api.R
import com.example.nasa_api.presentation.onboarding.OnboardingActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startWelcomeScreen()
        }, 6000.toLong())
    }


    private fun startWelcomeScreen() {
        startActivity(OnboardingActivity.getStartIntent(this))
        finish()
    }
}