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

    private val _topNewsList: MutableStateFlow<MutableList<News>> =
        MutableStateFlow(mutableListOf())
    val topNewsList: StateFlow<MutableList<News>>
        get() = _topNewsList

    private val _categoryNewsList: MutableStateFlow<MutableList<News>> =
        MutableStateFlow(mutableListOf())
    val categoryNewsList: StateFlow<MutableList<News>>
        get() = _categoryNewsList

    fun getNewsList(category: String?) {
        viewModelScope.launch {
            newsRepository.getNewsList(category = category)
                .collect {
                    Timber.tag(TAG).e(it.toString())
                    if(category == null)
                        _topNewsList.value = it.toMutableList()
                    else
                        _categoryNewsList.value = it.toMutableList()
                }
        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}