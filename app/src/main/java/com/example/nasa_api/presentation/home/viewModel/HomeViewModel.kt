package com.example.nasa_api.presentation.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasa_api.api.model.NasaRepository
import com.example.nasa_api.data.model.Apod
import com.example.nasa_api.mechanism.Util.Utils
import java.text.SimpleDateFormat
import java.util.*

class HomeViewModel : ViewModel() {

    private var _nasaImages = MutableLiveData<List<Apod>>()
    val nasaImage: LiveData<List<Apod>>
        get() = _nasaImages

    private var range: Int = 30

    init {
        Thread(Runnable {
            loadApodList()
        }).start()
    }

    private fun loadApodList() {
        val periodPhotos = Utils.catchRangeDate(range)
        val nasaApiResult = NasaRepository.getApodList(periodPhotos.startDate, periodPhotos.endDate)
        nasaApiResult?.let {
            _nasaImages.postValue(it)
        }
    }
}