package com.wanted.preob.newsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String = "No Title",
    val author: String? = "",
    val content: String? = "",
    val url: String? = "",
    val imgUrl: String? = "",
    val time: String? = "",
    val isSaved: Boolean = false
): Parcelable