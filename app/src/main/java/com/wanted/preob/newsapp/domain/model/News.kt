package com.wanted.preob.newsapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val title: String = "No Title",
    val author: String? = "",
    val content: String? = "",
    val url: String? = "",
    val imgUrl: String? = "",
    val time: String? = "",
    val isSaved: Boolean = false
)
