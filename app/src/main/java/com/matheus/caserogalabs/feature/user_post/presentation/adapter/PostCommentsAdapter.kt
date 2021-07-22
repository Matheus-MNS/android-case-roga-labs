package com.matheus.caserogalabs.feature.user_post.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.caserogalabs.databinding.ItemCommentsRowBinding
import com.matheus.caserogalabs.feature.user_post.presentation.model.CommentsModel

class PostCommentsAdapter(private val list: List<CommentsModel>) :
    RecyclerView.Adapter<PostCommentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCommentsRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(private val binding: ItemCommentsRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(commentsItem: CommentsModel) {
            with(binding) {
                userName.text = commentsItem.name
                userEmail.text = commentsItem.email
                userCommentary.text = commentsItem.body
            }
        }
    }
}