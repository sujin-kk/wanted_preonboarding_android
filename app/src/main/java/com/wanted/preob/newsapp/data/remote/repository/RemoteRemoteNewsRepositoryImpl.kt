package com.wanted.preob.newsapp.data.remote.repository

import com.wanted.preob.newsapp.data.api.NewsApi
import com.wanted.preob.newsapp.data.mapper.RemoteMapper
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
    override suspend fun getNewsList(category: String?): Flow<List<News>> = flow {
        kotlin.runCatching {
            newsApi.getNews(category = category)
        }
            .onSuccess {
                Timber.tag(TAG).e(it.toString())
                val articles = it.articles
                emit(
                    articles!!.map { article ->
                    RemoteMapper.mapToDomainNews(article = article)
                    }
                )
            }
            .onFailure {
                Timber.e(it)
            }
    }

    companion object {
        private const val TAG = "NewsRepositoryImpl"
    }
}