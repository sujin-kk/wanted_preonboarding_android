package com.wanted.preob.newsapp.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.wanted.preob.newsapp.R
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("bindImage")
fun ImageView.bindImage(imgUrl: String?) {
    imgUrl?.let {
        Glide.with(this)
            .load(imgUrl)
            .error(R.drawable.ic_none_img)
            .placeholder(R.drawable.ic_loading)
            .centerCrop()
            .into(this)
    }
}

@BindingAdapter("bindTimeText")
fun TextView.bindTimeText(publishedAt: String) {
    val sf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
    val now = sf.format(Date(System.currentTimeMillis()))

    val nowDate = sf.parse(now)!!
    val beforeDate = sf.parse(publishedAt)!!

    val diff = nowDate.time - beforeDate.time
    val diffSec = diff / 1000
    val diffMin = diff / (60 * 1000)
    val diffHour = diff / (60 * 60 * 1000)
    val diffDay = diff / (60 * 60 * 24 * 1000)


    text = when {
        diffDay > 0 -> "$diffDay days ago"
        diffHour > 0 -> "$diffHour hours ago"
        diffMin > 0 -> "$diffMin minutes ago"
        else -> "$diffSec seconds ago"
    }
}

@BindingAdapter("bindCategoryImage")
fun ImageView.bindCategoryImage(resId: Int) {
    Glide.with(this)
        .load(resId)
        .into(this)
}

