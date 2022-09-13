package com.wanted.preob.newsapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "local_news")
data class LocalNews(
    val title: String = "No Title",
    val author: String? = "",
    val content: String? = "",
    val url: String? = "",
    val imgUrl: String? = "",
    val time: String? = "",
    val isSaved: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    val nid: Int = 0
}
