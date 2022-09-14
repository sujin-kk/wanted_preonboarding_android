package com.wanted.preob.newsapp.presentation.ui.main

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.wanted.preob.newsapp.domain.model.News
import com.wanted.preob.newsapp.domain.repository.local.LocalNewsRepository
import com.wanted.preob.newsapp.domain.repository.remote.RemoteNewsRepository
import com.wanted.preob.newsapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val localNewsRepository: LocalNewsRepository,
    private val remoteNewsRepository: RemoteNewsRepository
): BaseViewModel() {

    // top news
    private val _topNewsList: MutableStateFlow<PagingData<News>> =
        MutableStateFlow(PagingData.empty())
    val topNewsList: StateFlow<PagingData<News>>
        get() = _topNewsList

    // category news
    private val _categoryNewsList: MutableStateFlow<PagingData<News>> =
        MutableStateFlow(PagingData.empty())
    val categoryNewsList: StateFlow<PagingData<News>>
        get() = _categoryNewsList

    // saved
    private val _savedNewsList: MutableStateFlow<MutableList<News>> =
        MutableStateFlow(mutableListOf())
    val savedNewsList: StateFlow<MutableList<News>>
        get() = _savedNewsList

    // top news, category news
    fun getNewsList(category: String?) {
        viewModelScope.launch {
            remoteNewsRepository.getNewsList(category = category)
                .cachedIn(viewModelScope)
                .collect {
                    Timber.tag(TAG).e(it.toString())
                    if(category == null)
                        _topNewsList.value = it
                    else
                        _categoryNewsList.value = it
                }
        }
    }

    fun getSavedNewsList() {
        viewModelScope.launch(Dispatchers.IO) {
            localNewsRepository.getAllNews()
                .collect {
                    Timber.tag(TAG).e(it.toString())
                    _savedNewsList.value = it.toMutableList()
                }
        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}