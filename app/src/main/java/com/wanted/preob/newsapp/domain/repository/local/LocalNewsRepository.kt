package com.wanted.preob.newsapp.domain.repository.local

import com.wanted.preob.newsapp.domain.model.News
import kotlinx.coroutines.flow.Flow

interface LocalNewsRepository {
    suspend fun getAllNews(): Flow<List<News>>

    suspend fun saveNews(news: News)

    suspend fun deleteNews(title: String)

    suspend fun isSavedNews(title: String): Boolean
}