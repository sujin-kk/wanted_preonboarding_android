package com.wanted.preob.newsapp.presentation.ui.topNews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wanted.preob.newsapp.databinding.ItemNewsBinding
import com.wanted.preob.newsapp.domain.model.News

class NewsListAdapter(
    private val newsList: MutableList<News>,
    private val onClick: (News) -> Unit,
)
    : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int = newsList.size

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
}