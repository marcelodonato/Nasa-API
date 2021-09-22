package com.example.nasa_api.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasa_api.R
import com.example.nasa_api.data.model.Apod
import com.example.nasa_api.presentation.base.BaseRecyclerAdapter

class HomeAdapter : BaseRecyclerAdapter<Apod, HomeAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(mData[position], position)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(viewGroup.context).inflate(
            (R.layout.item_home), viewGroup,
            false
        )
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(apod: Apod, position: Int) {

        }

    }

    override fun validateDate() = false

}
