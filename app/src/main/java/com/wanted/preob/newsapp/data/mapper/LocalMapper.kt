package com.wanted.preob.newsapp.data.mapper

import com.wanted.preob.newsapp.data.local.entity.LocalNews
import com.wanted.preob.newsapp.data.remote.model.Article
import com.wanted.preob.newsapp.domain.model.News

object LocalMapper {
    fun mapToDomainNews(localNews: LocalNews): News {
        with(localNews) {
            return News(
                title = this.title,
                author = this.author,
                content = this.content,
                url = this.url,
                imgUrl = this.imgUrl,
                time = this.time,
                isSaved = false
            )
        }
    }

    fun mapToLocalNews(news: News): LocalNews {
        with(news) {
            return LocalNews(
                title = this.title,
                author = this.author,
                content = this.content,
                url = this.url,
                imgUrl = this.imgUrl,
                time = this.time,
                isSaved = false
            )
        }
    }
}