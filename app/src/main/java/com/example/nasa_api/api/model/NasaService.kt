package com.example.nasa_api.api.model

import com.example.nasa_api.data.model.Apod
import com.example.nasa_api.mechanism.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaService {

    @GET("planetary/apod")
    fun getList(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") api: String = API_KEY
    ): Call<List<Apod>>

}