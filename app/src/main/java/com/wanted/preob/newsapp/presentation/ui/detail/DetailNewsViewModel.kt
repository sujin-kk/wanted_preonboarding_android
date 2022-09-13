package com.wanted.preob.newsapp.presentation.ui.detail

import androidx.lifecycle.viewModelScope
import com.wanted.preob.newsapp.domain.model.News
import com.wanted.preob.newsapp.domain.repository.local.LocalNewsRepository
import com.wanted.preob.newsapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailNewsViewModel @Inject constructor(
    private val localNewsRepository: LocalNewsRepository,
): BaseViewModel() {

    private val _detailNews: MutableStateFlow<News> =
        MutableStateFlow(News())
    val detailNews: StateFlow<News>
        get() = _detailNews

    fun setDetailNews(news: News) {
        _detailNews.update {
            news
        }
    }

    fun checkSaveState(news: News) {
        viewModelScope.launch(Dispatchers.IO) {
            if(localNewsRepository.isSavedNews(title = news.title)) {
                _detailNews.update {
                    news.copy(isSaved = true)
                }
            }
        }
    }

    fun changeSaveState() {
        if(_detailNews.value.isSaved) deleteNews()
        else saveNews()
    }

    private fun saveNews() {
        viewModelScope.launch(Dispatchers.IO) {
            localNewsRepository.saveNews(news = _detailNews.value)
            _detailNews.update {
                _detailNews.value.copy(isSaved = true)
            }
        }
    }

    private fun deleteNews() {
        viewModelScope.launch(Dispatchers.IO) {
            localNewsRepository.deleteNews(title = _detailNews.value.title)
            _detailNews.update {
                _detailNews.value.copy(isSaved = false)
            }
        }
    }

    companion object {
        private const val TAG = "DetailNewsViewModel"
    }

}