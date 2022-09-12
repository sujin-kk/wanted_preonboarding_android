package com.wanted.preob.newsapp.data.mapper

import com.wanted.preob.newsapp.data.model.response.Article
import com.wanted.preob.newsapp.domain.model.News

object Mapper {
    fun mapToDomainNews(article: Article): News {
        with(article) {
            return News(
                title = this.title,
                author = this.author,
                content = this.content,
                url = this.url,
                imgUrl = this.urlToImage,
                time = this.publishedAt,
                isSaved = false
            )
        }
    }
}