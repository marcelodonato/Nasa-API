package com.example.nasa_api.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nasa_api.R
import com.example.nasa_api.data.model.Apod
import com.example.nasa_api.mechanism.EXTRA_APOD

class DetailsActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context, apod: Apod? = null) =
            Intent(context, DetailsActivity::class.java).apply {
                putExtra(EXTRA_APOD, apod)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}