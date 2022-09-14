package com.wanted.preob.newsapp.domain.repository.remote

import androidx.paging.PagingData
import com.wanted.preob.newsapp.domain.model.News
import kotlinx.coroutines.flow.Flow

interface RemoteNewsRepository {
    suspend fun getNewsList(category: String?): Flow<PagingData<News>>
}