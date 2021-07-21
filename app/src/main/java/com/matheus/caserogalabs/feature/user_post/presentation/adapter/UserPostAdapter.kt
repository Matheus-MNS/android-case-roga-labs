package com.matheus.caserogalabs.feature.user_post.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.caserogalabs.common.utils.AdapterItemClickListener
import com.matheus.caserogalabs.common.utils.AdapterItemWithParameterClickListener
import com.matheus.caserogalabs.databinding.UserPostRecyclerBinding
import com.matheus.caserogalabs.feature.user_post.presentation.model.PostModel

class UserPostAdapter(private val list: List<PostModel>) :
    RecyclerView.Adapter<UserPostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostAdapter.ViewHolder {
        val binding =
            UserPostRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UserPostAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    var itemClickListener: AdapterItemWithParameterClickListener<Int> = {}

    inner class ViewHolder(private val binding: UserPostRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(postItem: PostModel) {
            with(binding) {
                titlePost.text = postItem.title
                bodyPost.text = postItem.body
            }
            itemView.setOnClickListener {
                itemClickListener(postItem.id)
            }
        }
    }
}