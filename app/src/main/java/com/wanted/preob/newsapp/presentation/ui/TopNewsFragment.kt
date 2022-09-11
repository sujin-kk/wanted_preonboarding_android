package com.wanted.preob.newsapp.presentation.ui

import android.os.Bundle
import android.view.View
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentTopNewsBinding
import com.wanted.preob.newsapp.domain.model.enums.HeaderType
import com.wanted.preob.newsapp.presentation.base.BaseFragment

class TopNewsFragment : BaseFragment<FragmentTopNewsBinding>(R.layout.fragment_top_news) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }


    private fun initListener() {
        binding.topNewsHeader.headerType = HeaderType.BASE
        binding.topNewsHeader.headerTitleTv.text = getString(R.string.app_name)
    }

}