package com.example.nasa_api.presentation.onboarding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nasa_api.R
import com.example.nasa_api.databinding.ActivityOnboardingBinding
import com.example.nasa_api.presentation.view.HomeActivity

class OnboardingActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, OnboardingActivity::class.java)
    }

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setStartAPI()
    }

    private fun setStartAPI(){

        binding.buttonOnboarding.setOnClickListener {
            startActivity(HomeActivity.getStartIntent(this))
            finish()
        }

    }


}