package com.wanted.preob.newsapp.presentation.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentDetailNewsBinding
import com.wanted.preob.newsapp.domain.model.enums.HeaderType
import com.wanted.preob.newsapp.presentation.base.BaseFragment
import com.wanted.preob.newsapp.presentation.ui.main.MainViewModel
import timber.log.Timber


class DetailNewsFragment : BaseFragment<FragmentDetailNewsBinding>(R.layout.fragment_detail_news) {
    private val args by navArgs<DetailNewsFragmentArgs>()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag(TAG).e("받은 뉴스 데이터 : ${args.news}")
        initView()
        initListener()
    }

    private fun initView() {
        binding.news = args.news
    }
    private fun initListener() {
        binding.detailNewsHeader.apply {
            this.headerType = HeaderType.BACK
            this.headerBackTitleTv.text = args.news.title
            this.headerBackIv.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    companion object {
        const val TAG = "DetailNewsFragment"
    }
}