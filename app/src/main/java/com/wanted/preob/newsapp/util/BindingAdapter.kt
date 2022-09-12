package com.wanted.preob.newsapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.wanted.preob.newsapp.R

@BindingAdapter("bindImage")
fun ImageView.bindImage(imgUrl: String?) {
    imgUrl?.let {
        Glide.with(this).load(imgUrl).error(R.drawable.ic_none_img)
            .placeholder(R.drawable.ic_loading)
            .centerCrop().into(this)
    }
}