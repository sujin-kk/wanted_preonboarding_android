package com.wanted.preob.newsapp.presentation.ui.category

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentCategoryBinding
import com.wanted.preob.newsapp.domain.model.enums.Category
import com.wanted.preob.newsapp.domain.model.enums.HeaderType
import com.wanted.preob.newsapp.presentation.base.BaseFragment
import timber.log.Timber


class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initListener()
    }

    private fun initListener() {
        binding.categoryHeader.apply {
            this.headerType = HeaderType.BASE
            this.headerTitleTv.text = getString(R.string.select_category_header_title)
        }
    }

    private fun initAdapter() {
        val categoryList = listOf<Category>(
            Category.BUSINESS,
            Category.ENTERTAINMENT,
            Category.GENERAL,
            Category.HEALTH,
            Category.SCIENCE,
            Category.SPORTS,
            Category.TECHNOLOGY
        )

        categoryAdapter = CategoryAdapter(categoryList = categoryList, onClick = { navigateToCategoryNews(it) })
        binding.categoryRv.adapter = categoryAdapter
    }

    private fun navigateToCategoryNews(category: Category) {
        Timber.tag(TAG).e("$category 뉴스 리스트로 이동")
        findNavController().navigate(
            CategoryFragmentDirections.actionCategoryToNews(category.title)
        )

    }

    companion object {
        const val TAG = "CategoryFragment"
    }
}