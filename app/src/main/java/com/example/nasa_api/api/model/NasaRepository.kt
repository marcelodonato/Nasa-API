package com.example.nasa_api.api.model

import com.example.nasa_api.api.model.NasaRepository.HTTPLogger.getLogger
import com.example.nasa_api.data.model.Apod
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NasaRepository {

    private val service: NasaService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getLogger())
            .build()

        getLogger()
        service = retrofit.create(NasaService::class.java)
    }

    object HTTPLogger {
        fun getLogger(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }
    }

    fun getApodList(startDate: String, endDate: String): List<Apod>? {
        val call = service.getList(startDate, endDate)
        return call.execute().body()
    }

}
