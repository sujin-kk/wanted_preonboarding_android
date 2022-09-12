package com.wanted.preob.newsapp.presentation.ui.main

import com.wanted.preob.newsapp.domain.model.News
import com.wanted.preob.newsapp.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: BaseViewModel() {

    private val _topNewsList: MutableStateFlow<ArrayList<News>> =
        MutableStateFlow(arrayListOf())
    val topNewsList: StateFlow<ArrayList<News>>
        get() = _topNewsList

}