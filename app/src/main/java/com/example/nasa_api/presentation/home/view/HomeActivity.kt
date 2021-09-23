package com.example.nasa_api.presentation.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nasa_api.data.model.Apod
import com.example.nasa_api.databinding.ActivityHomeBinding
import com.example.nasa_api.presentation.details.DetailsActivity
import com.example.nasa_api.presentation.home.adapter.HomeAdapter
import com.example.nasa_api.presentation.home.viewModel.HomeViewModel
import com.example.nasa_api.presentation.home.viewModel.HomeViewModelFactory
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    private lateinit var binding: ActivityHomeBinding
    private val adapterList: HomeAdapter by lazy {
        HomeAdapter()
    }
    private val viewModel by lazy {
        ViewModelProvider(this, HomeViewModelFactory())
            .get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservable()
    }

    private fun setupObservable() {
        viewModel.nasaImage.observe(this, Observer {
            setupRecycler(it)
        })
    }

    private fun setupRecycler(apod: List<Apod>) {

        loader_nasa.visibility = View.VISIBLE

        adapterList.data = apod.toMutableList()
        binding.nasaRecyclerView.apply {
            adapter = adapterList

            adapterList.onItemClickListener = {
                startActivity(it.let{apod -> DetailsActivity.getStartIntent(context, apod)})
            }
        }

        loader_nasa.visibility = View.GONE
    }

}