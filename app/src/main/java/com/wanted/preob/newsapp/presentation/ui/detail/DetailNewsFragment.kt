package com.wanted.preob.newsapp.presentation.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentDetailNewsBinding
import com.wanted.preob.newsapp.presentation.base.BaseFragment
import com.wanted.preob.newsapp.presentation.ui.main.MainViewModel


class DetailNewsFragment : BaseFragment<FragmentDetailNewsBinding>(R.layout.fragment_detail_news) {
    private val args by navArgs<DetailNewsFragmentArgs>()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListener()
        bindingViewModel()
    }

    private fun initView() {
        binding.news = args.news
    }
    private fun initListener() {
        TODO("Not yet implemented")
    }

    private fun bindingViewModel() {
        TODO("Not yet implemented")
    }

}