package com.wanted.preob.newsapp.domain.repository.remote.news

import com.wanted.preob.newsapp.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsList(category: String?): Flow<List<News>>
}