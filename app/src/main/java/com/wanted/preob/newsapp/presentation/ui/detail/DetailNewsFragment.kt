package com.wanted.preob.newsapp.presentation.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentDetailNewsBinding
import com.wanted.preob.newsapp.domain.model.enums.HeaderType
import com.wanted.preob.newsapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailNewsFragment : BaseFragment<FragmentDetailNewsBinding>(R.layout.fragment_detail_news) {
    private val args by navArgs<DetailNewsFragmentArgs>()
    private val detailNewsViewModel: DetailNewsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag(TAG).e("받은 뉴스 데이터 : ${args.news}")
        bindingViewModel()
        initListener()
    }

    private fun initListener() {

        binding.detailNewsHeader.apply {
            this.headerType = HeaderType.BACK
            this.headerBackTitleTv.text = args.news.title
            this.headerBackIv.setOnClickListener {
                findNavController().navigateUp()
            }
        }

        binding.detailNewsSaveBtn.setOnClickListener {
            detailNewsViewModel.changeSaveState()
        }
    }

    private fun bindingViewModel() {
        detailNewsViewModel.setDetailNews(news = args.news)
        detailNewsViewModel.checkSaveState(news = args.news)

        lifecycleScope.launchWhenStarted {
            detailNewsViewModel.detailNews.collect {
                binding.news = it
                Timber.tag(TAG).e("현재 뉴스 상태 $it")
            }
        }
    }

    companion object {
        private const val TAG = "DetailNewsFragment"
    }
}