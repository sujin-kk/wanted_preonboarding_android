package com.wanted.preob.newsapp.presentation.ui.saved

import android.os.Bundle
import android.view.View
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.FragmentSavedBinding
import com.wanted.preob.newsapp.presentation.base.BaseFragment
import timber.log.Timber

class SavedFragment : BaseFragment<FragmentSavedBinding>(R.layout.fragment_saved) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e(TAG)

    }

    companion object {
        const val TAG = "SavedFragment"
    }
}