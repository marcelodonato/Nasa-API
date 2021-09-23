package com.example.nasa_api.presentation.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasa_api.R
import com.example.nasa_api.data.model.Apod
import com.example.nasa_api.mechanism.Util.Utils
import com.example.nasa_api.presentation.base.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.item_home.view.*

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
            itemView.apply {
                val imageApod = findViewById<AppCompatImageView>(R.id.image_apod)
                val imageProgress = findViewById<ProgressBar>(R.id.image_progress)

                Utils.setImageUrl(itemView.context, apod.url, imageApod, imageProgress)

                container.setOnClickListener {
                    onItemClickListener?.invoke(apod)
                }


            }
        }
    }

    override fun validateDate() = false

}
