package com.wanted.preob.newsapp.data.local.dao

import androidx.room.*
import com.wanted.preob.newsapp.domain.model.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * from News")
    fun getAllNews(): Flow<List<News>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNews(news: News)

    @Query("DELETE FROM News WHERE title =:title")
    fun deleteNews(title: String)

    @Query("SELECT EXISTS(SELECT * FROM News WHERE title =:title)")
    fun isSavedNews(title: String): Boolean
}