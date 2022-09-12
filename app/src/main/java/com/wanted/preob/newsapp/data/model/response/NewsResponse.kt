package com.wanted.preob.newsapp.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val status: String,
    val totalResults: Int?,
    val articles: List<Article>?,
    val code: String?,
    val message: String?
)

@Serializable
data class Article(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
)

@Serializable
data class Source(
    val id: String?,
    val name: String
)
