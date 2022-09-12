package com.wanted.preob.newsapp.presentation.ui.category

import android.os.Bundle
import android.view.View
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentCategoryBinding
import com.wanted.preob.newsapp.presentation.base.BaseFragment
import timber.log.Timber


class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e(TAG)
    }

    companion object {
        const val TAG = "CategoryFragment"
    }
}