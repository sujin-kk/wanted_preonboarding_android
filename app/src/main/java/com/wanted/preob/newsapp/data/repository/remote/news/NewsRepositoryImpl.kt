package com.wanted.preob.newsapp.data.repository.remote.news

import com.wanted.preob.newsapp.data.api.NewsApi
import com.wanted.preob.newsapp.data.mapper.Mapper
import com.wanted.preob.newsapp.data.model.response.NewsResponse
import com.wanted.preob.newsapp.domain.model.News
import com.wanted.preob.newsapp.domain.repository.remote.news.NewsRepository
import com.wanted.preob.newsapp.presentation.ui.main.MainViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {
    override suspend fun getNewsList(category: String?): Flow<List<News>> = flow {
        kotlin.runCatching {
            newsApi.getNews(category = category)
        }
            .onSuccess {
                Timber.tag(TAG).e(it.toString())
                val articles = it.articles
                emit(
                    articles!!.map { article ->
                    Mapper.mapToDomainNews(article = article)
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