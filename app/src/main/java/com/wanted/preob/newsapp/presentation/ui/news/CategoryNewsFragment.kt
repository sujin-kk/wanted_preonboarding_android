package com.wanted.preob.newsapp.presentation.ui.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentCategoryNewsBinding
import com.wanted.preob.newsapp.domain.model.News
import com.wanted.preob.newsapp.domain.model.enums.HeaderType
import com.wanted.preob.newsapp.presentation.base.BaseFragment
import com.wanted.preob.newsapp.presentation.ui.main.MainViewModel
import com.wanted.preob.newsapp.presentation.ui.news.adapter.NewsListAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CategoryNewsFragment : BaseFragment<FragmentCategoryNewsBinding>(R.layout.fragment_category_news) {
    private lateinit var categoryNewsListAdapter: NewsListAdapter
    private val args by navArgs<CategoryNewsFragmentArgs>()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.getNewsList(args.category)
        initAdapter()
        initListener()
        bindingViewModel()
    }

    private fun initListener() {
        binding.categoryNewsHeader.apply {
            this.headerType = HeaderType.BACK

            this.headerBackTitleTv.text = getString(R.string.category_header_title).format(args.category)

            this.headerBackIv.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun initAdapter() {
        categoryNewsListAdapter = NewsListAdapter(newsList = mainViewModel.categoryNewsList.value, onClick = { goToDetailNews(it) })
        binding.categoryNewsRv.adapter = categoryNewsListAdapter
    }

    private fun bindingViewModel() {
        lifecycleScope.launchWhenStarted {
            mainViewModel.categoryNewsList.collect {
                Timber.tag(TopNewsFragment.TAG).e(it.toString())
                categoryNewsListAdapter.updateNewsList(it)
            }
        }
    }

    private fun goToDetailNews(news: News) {
        Timber.tag(TAG).e("Category News -> Detail")
        findNavController().navigate(
            CategoryNewsFragmentDirections.actionCategoryNewsToDetail(news = news)
        )
    }

    companion object {
        const val TAG = "CategoryNewsFragment"
    }

}