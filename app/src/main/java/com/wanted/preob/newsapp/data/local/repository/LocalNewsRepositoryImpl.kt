package com.wanted.preob.newsapp.data.local.repository

import com.wanted.preob.newsapp.data.local.dao.NewsDao
import com.wanted.preob.newsapp.domain.model.News
import com.wanted.preob.newsapp.domain.repository.local.LocalNewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class LocalNewsRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao
) : LocalNewsRepository {

    override suspend fun getAllNews(): Flow<List<News>> =
        newsDao.getAllNews()


    override suspend fun saveNews(news: News) {
        newsDao.saveNews(news)
    }

    override suspend fun deleteNews(title: String) {
        newsDao.deleteNews(title)
    }

    override suspend fun isSavedNews(title: String): Boolean =
        newsDao.isSavedNews(title)

    companion object {
        private const val TAG = "LocalNewsRepositoryImpl"
    }
}