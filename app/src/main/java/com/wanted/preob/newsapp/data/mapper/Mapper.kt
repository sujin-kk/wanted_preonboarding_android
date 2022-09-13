package com.wanted.preob.newsapp.data.mapper

import com.wanted.preob.newsapp.data.remote.model.Article
import com.wanted.preob.newsapp.domain.model.News
import java.text.SimpleDateFormat
import java.util.*

object Mapper {
    fun mapToDomainNews(article: Article): News {
        with(article) {
            return News(
                title = this.title,
                author = this.author,
                content = this.content,
                url = this.url,
                imgUrl = this.urlToImage,
                time = mapToTime(publishedAt = this.publishedAt),
                isSaved = false
            )
        }
    }

    private fun mapToTime(publishedAt: String): String {
        val sf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        val now = sf.format(Date(System.currentTimeMillis()))

        val nowDate = sf.parse(now)!!
        val beforeDate = sf.parse(publishedAt)!!

        val diff = nowDate.time - beforeDate.time
        val diffSec = diff / 1000
        val diffMin = diff / (60 * 1000)
        val diffHour = diff / (60 * 60 * 1000)
        val diffDay = diff / (60 * 60 * 24 * 1000)


        return when {
            diffDay > 0 -> "$diffDay days ago"
            diffHour > 0 -> "$diffHour hours ago"
            diffMin > 0 -> "$diffMin minutes ago"
            else -> "$diffSec seconds ago"
        }
    }
}