package com.example.nasa_api.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.nasa_api.R
import com.example.nasa_api.data.model.Apod
import com.example.nasa_api.mechanism.EXTRA_APOD
import kotlinx.android.synthetic.main.include_card_image_description.*
import kotlinx.android.synthetic.main.include_description.*

class DetailsActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context, apod: Apod? = null) =
            Intent(context, DetailsActivity::class.java).apply {
                putExtra(EXTRA_APOD, apod)
            }
    }

    private lateinit var nasaData : Apod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        clickListeners()
        receiveData()
    }

    private fun clickListeners() {
        back.setOnClickListener { finish() }
    }

private fun receiveData(){
    nasaData = intent?.getSerializableExtra(EXTRA_APOD) as Apod
    nasaData.also {

        Glide.with(this).load(it.url).into(image_apod_description)

        title_description.text = it.title
        message_description.text = it.explanation
        date_description.text = it.date
    }
}
}