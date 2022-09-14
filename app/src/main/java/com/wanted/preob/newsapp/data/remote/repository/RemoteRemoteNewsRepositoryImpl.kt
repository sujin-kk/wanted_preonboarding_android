package com.wanted.preob.newsapp.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wanted.preob.newsapp.data.api.NewsApi
import com.wanted.preob.newsapp.data.mapper.RemoteMapper
import com.wanted.preob.newsapp.data.paging.NewsPagingSource
import com.wanted.preob.newsapp.domain.model.News
import com.wanted.preob.newsapp.domain.repository.remote.RemoteNewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRemoteNewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : RemoteNewsRepository {

    override suspend fun getNewsList(category: String?): Flow<PagingData<News>> {
        return Pager(PagingConfig(PAGE_SIZE)) {
                NewsPagingSource(newsApi = newsApi, category = category)
        }.flow
    }

    companion object {
        private const val TAG = "RemoteNewsRepositoryImpl"
        private const val PAGE_SIZE = 20
    }

}