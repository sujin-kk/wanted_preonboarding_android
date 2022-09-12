package com.wanted.preob.newsapp.di

import com.wanted.preob.newsapp.data.repository.remote.news.NewsRepositoryImpl
import com.wanted.preob.newsapp.domain.repository.remote.news.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsNewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository
}