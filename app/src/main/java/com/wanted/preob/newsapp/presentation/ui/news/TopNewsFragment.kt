package com.wanted.preob.newsapp.presentation.ui.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentTopNewsBinding
import com.wanted.preob.newsapp.domain.model.News
import com.wanted.preob.newsapp.domain.model.enums.HeaderType
import com.wanted.preob.newsapp.presentation.base.BaseFragment
import com.wanted.preob.newsapp.presentation.ui.main.MainViewModel
import com.wanted.preob.newsapp.presentation.ui.news.adapter.NewsListAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TopNewsFragment : BaseFragment<FragmentTopNewsBinding>(R.layout.fragment_top_news) {
    private lateinit var topNewsListAdapter: NewsListAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.getNewsList(null)
        initAdapter()
        initListener()
        bindingViewModel()
    }

    private fun initListener() {
        binding.topNewsHeader.headerType = HeaderType.BASE
        binding.topNewsHeader.headerTitleTv.text = getString(R.string.app_name)
    }

    private fun initAdapter() {
        topNewsListAdapter = NewsListAdapter(newsList = mainViewModel.topNewsList.value, onClick = { goToDetailNews(it) })
        binding.topNewsRv.adapter = topNewsListAdapter
    }

    private fun bindingViewModel() {
        lifecycleScope.launchWhenStarted {
            mainViewModel.topNewsList.collect {
                Timber.tag(TAG).e(it.toString())
                topNewsListAdapter.updateNewsList(it)
            }
        }
    }

    private fun goToDetailNews(news: News) {
        Timber.tag(TAG).e("Top News -> Detail")
        findNavController().navigate(
            TopNewsFragmentDirections.actionNewsToDetail(news = news)
        )
    }

    companion object {
        const val TAG = "TopNewsFragment"
    }
}