package com.wanted.preob.newsapp.presentation.ui.saved

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentSavedBinding
import com.wanted.preob.newsapp.domain.model.News
import com.wanted.preob.newsapp.domain.model.enums.HeaderType
import com.wanted.preob.newsapp.presentation.base.BaseFragment
import com.wanted.preob.newsapp.presentation.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SavedFragment : BaseFragment<FragmentSavedBinding>(R.layout.fragment_saved) {
    private lateinit var savedListAdapter: SavedListAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.getSavedNewsList()
        initAdapter()
        initListener()
        bindingViewModel()
    }

    private fun initAdapter() {
        savedListAdapter = SavedListAdapter(onClick = { goToDetailNews(it) })
        binding.savedNewsRv.adapter = savedListAdapter
    }

    private fun initListener() {
        binding.savedHeader.headerType = HeaderType.BASE
        binding.savedHeader.headerTitleTv.text = getString(R.string.saved_header_title)
    }

    private fun bindingViewModel() {
        lifecycleScope.launchWhenStarted {
            mainViewModel.savedNewsList.collect {
                Timber.tag(TAG).e(it.toString())
                binding.isEmptyNews = it.isEmpty()
                savedListAdapter.submitList(it)
            }
        }
    }

    private fun goToDetailNews(news: News) {
        Timber.tag(TAG).e("Top News -> Detail")
        findNavController().navigate(
            SavedFragmentDirections.actionSavedNewsToDetail(news = news)
        )
    }

    companion object {
        private const val TAG = "SavedFragment"
    }
}