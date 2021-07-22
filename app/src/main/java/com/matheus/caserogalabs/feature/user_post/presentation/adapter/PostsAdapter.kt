package com.matheus.caserogalabs.feature.user_post.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.caserogalabs.common.utils.AdapterItemWithParameterClickListener
import com.matheus.caserogalabs.databinding.ItemPostRowBinding
import com.matheus.caserogalabs.feature.user_post.presentation.model.PostModel

class PostsAdapter(private val list: List<PostModel>) :
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.ViewHolder {
        val binding = ItemPostRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostsAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    var itemClickListener: AdapterItemWithParameterClickListener<Pair<Int,String>> = {}

    inner class ViewHolder(private val binding: ItemPostRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(postItem: PostModel) {
            with(binding) {
                titlePost.text = postItem.title
                bodyPost.text = postItem.body
            }
            itemView.setOnClickListener {
                itemClickListener(Pair(postItem.id,postItem.title))
            }
        }
    }
}