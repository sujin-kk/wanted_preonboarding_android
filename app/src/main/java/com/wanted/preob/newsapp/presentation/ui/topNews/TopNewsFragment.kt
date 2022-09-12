package com.wanted.preob.newsapp.presentation.ui.topNews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentTopNewsBinding
import com.wanted.preob.newsapp.domain.model.enums.HeaderType
import com.wanted.preob.newsapp.presentation.base.BaseFragment
import com.wanted.preob.newsapp.presentation.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TopNewsFragment : BaseFragment<FragmentTopNewsBinding>(R.layout.fragment_top_news) {
    private lateinit var topNewsListAdapter: NewsListAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e(TAG)
        initAdapter()
        initListener()
    }

    private fun initListener() {
        binding.topNewsHeader.headerType = HeaderType.BASE
        binding.topNewsHeader.headerTitleTv.text = getString(R.string.app_name)
    }

    private fun initAdapter() {
        topNewsListAdapter = NewsListAdapter(newsList = mainViewModel.topNewsList.value, onClick = { goToDetailNews() })
        binding.topNewsRv.adapter = topNewsListAdapter
    }

    private fun goToDetailNews() {

    }

    companion object {
        const val TAG = "TopNewsFragment"
    }
}