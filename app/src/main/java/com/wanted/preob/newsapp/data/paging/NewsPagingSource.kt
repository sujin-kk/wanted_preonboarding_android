package com.wanted.preob.newsapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.wanted.preob.newsapp.data.api.NewsApi
import com.wanted.preob.newsapp.data.mapper.RemoteMapper
import com.wanted.preob.newsapp.domain.model.News
import kotlinx.coroutines.delay
import timber.log.Timber

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val category: String?
): PagingSource<Int, News>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        return try {
            // Start refresh at page 1 if undefined.
            val curKey = params.key ?: START_KEY

            if(curKey != START_KEY) delay(DELAY_MILLIS)

            val newsList = newsApi.getNews(category = category, page = curKey)
                .articles!!.map { article ->
                    RemoteMapper.mapToDomainNews(article = article)
                }

            Timber.tag(TAG).e("${curKey-1} $curKey ${curKey+1}")

            LoadResult.Page(
                data = newsList,
                prevKey = if (curKey == START_KEY) null else curKey - 1,
                nextKey = if (newsList.isEmpty()) null else curKey + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, News>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    companion object {
        const val START_KEY = 1
        const val DELAY_MILLIS = 1_000L
        const val TAG = "NewsPagingSource"
    }

}
