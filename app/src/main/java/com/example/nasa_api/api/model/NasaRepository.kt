package com.example.nasa_api.api.model


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NasaRepository {

    private val service : NasaService

    init{

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/planetary/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(NasaService::class.java)
    }
    
}
