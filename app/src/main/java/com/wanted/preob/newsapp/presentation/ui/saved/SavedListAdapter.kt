package com.wanted.preob.newsapp.presentation.ui.saved

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wanted.preob.newsapp.databinding.ItemNewsBinding
import com.wanted.preob.newsapp.domain.model.News

class SavedListAdapter(
    private val onClick: (News) -> Unit,
)
    : ListAdapter<News, SavedListAdapter.ViewHolder>(diffCallback)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(news = it)
        }
    }

    inner class ViewHolder(private val binding: ItemNewsBinding)
        :RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.apply {
                this.news = news
                this.itemNewsLayout.setOnClickListener {
                    onClick.invoke(news)
                }
            }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean =
                oldItem == newItem
        }
    }
}