package com.example.nasa_api.presentation.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nasa_api.R
import com.example.nasa_api.databinding.ActivityHomeBinding
import com.example.nasa_api.presentation.view.adapter.HomeAdapter

class HomeActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    private lateinit var binding: ActivityHomeBinding

    private val adapterList: HomeAdapter by lazy {
        HomeAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}