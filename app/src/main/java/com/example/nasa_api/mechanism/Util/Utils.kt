package com.example.nasa_api.mechanism.Util

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.nasa_api.R
import com.example.nasa_api.data.model.RangeDate
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun setImageUrl(
        context: Context?,
        imageUrl: String?,
        imageView: ImageView,
        progressBar: ProgressBar
    ) {
        imageUrl.let { photoUrl ->
            context?.let {
                Glide.with(it).load(photoUrl)
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?, model: Any?,
                            target: Target<Drawable>?, isFirstResource: Boolean
                        ): Boolean {
                            imageView.setImageResource(R.drawable.ic_close_x)
                            progressBar.visibility = View.GONE
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            progressBar.visibility = View.GONE
                            return false
                        }
                    }).into(imageView)
            }
        }
    }

    fun catchRangeDate(range: Int): RangeDate {
        val finalData: Calendar? = null

        val endDate = finalData?.apply {
            this.add(Calendar.DATE, -1)
        } ?: Calendar.getInstance()

        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).let {
            val endRange = it.format(endDate.time)
            val startRange = it.format(endDate.apply {
                this.add(Calendar.DATE, -range)
            }.time)

            return RangeDate(startDate = startRange, endDate = endRange)
        }
    }

}