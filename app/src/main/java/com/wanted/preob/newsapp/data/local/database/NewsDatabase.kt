package com.wanted.preob.newsapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wanted.preob.newsapp.data.local.dao.NewsDao
import com.wanted.preob.newsapp.domain.model.News

@Database(
    entities = [News::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsDao(): NewsDao
}