package com.hectorpolendo.examen.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun loadImages(imageView: ImageView, imageUrl: String?){
    Glide.with(imageView.context)
        .load(imageUrl)
        .apply(RequestOptions.centerCropTransform())
        .into(imageView)
}