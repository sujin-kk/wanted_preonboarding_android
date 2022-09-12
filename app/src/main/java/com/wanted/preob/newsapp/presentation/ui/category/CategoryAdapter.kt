package com.wanted.preob.newsapp.presentation.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wanted.preob.newsapp.databinding.ItemCategoryBinding
import com.wanted.preob.newsapp.domain.model.enums.Category

class CategoryAdapter (
    private val categoryList: List<Category>,
    private val onClick: (Category) -> Unit,
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

    inner class ViewHolder(private val binding: ItemCategoryBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.category = category
            binding.itemCategoryLayout.setOnClickListener {
                onClick.invoke(category)
            }
        }
    }
}