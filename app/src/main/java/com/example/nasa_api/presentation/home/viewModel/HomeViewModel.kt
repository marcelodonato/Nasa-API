package com.example.nasa_api.presentation.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasa_api.api.model.NasaRepository
import com.example.nasa_api.data.model.Apod
import java.text.SimpleDateFormat
import java.util.*

class HomeViewModel : ViewModel() {

    private var _nasaImages = MutableLiveData<List<Apod>>()
    val nasaImage: LiveData<List<Apod>>
        get() = _nasaImages

    private var range: Int = 30

    init {
        Thread(Runnable {
            catchRangeDate()
        }).start()
    }

    private fun catchRangeDate() {
        val finalData: Calendar? = null

        val endDate = finalData?.apply {
            this.add(Calendar.DATE, -1)
        } ?: Calendar.getInstance()

        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).let {
            val endRange = it.format(endDate.time)
            val startRange = it.format(endDate.apply {
                this.add(Calendar.DATE, -range)
            }.time)

            loadApodList(startRange, endRange)
        }
    }

    private fun loadApodList(startDate: String, endDate: String) {
        val nasaApiResult = NasaRepository.getApodList(startDate, endDate)

        nasaApiResult?.let {
            _nasaImages.postValue(it)
        }
    }
}