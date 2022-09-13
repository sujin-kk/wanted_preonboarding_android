package com.wanted.preob.newsapp.di

import android.content.Context
import androidx.room.Room
import com.wanted.preob.newsapp.data.local.dao.NewsDao
import com.wanted.preob.newsapp.data.local.database.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesNewsDatabase(
        @ApplicationContext context: Context
    ): NewsDatabase =
        Room.databaseBuilder(context, NewsDatabase::class.java, "news.db")
            .build()

    @Singleton
    @Provides
    fun providesNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao()
}