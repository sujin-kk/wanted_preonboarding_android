package com.wanted.preob.newsapp.presentation.ui.main

import androidx.lifecycle.viewModelScope
import com.wanted.preob.newsapp.domain.model.News
import com.wanted.preob.newsapp.domain.repository.remote.news.NewsRepository
import com.wanted.preob.newsapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): BaseViewModel() {

    init {
        getNewsList(null)
    }

    private val _topNewsList: MutableStateFlow<MutableList<News>> =
        MutableStateFlow(mutableListOf())
    val topNewsList: StateFlow<MutableList<News>>
        get() = _topNewsList

    fun getNewsList(category: String?) {
        viewModelScope.launch {
            newsRepository.getNewsList(category = category)
                .collect {
                    Timber.tag(TAG).e(it.toString())
                    _topNewsList.value = it.toMutableList()
                }
        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}