package com.matheus.caserogalabs.feature.user_post.presetantion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.caserogalabs.common.Post
import com.matheus.caserogalabs.databinding.UserPostRecyclerBinding

class UserPostAdapter(private val list: List<Post>) :
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

    inner class ViewHolder(private val binding: UserPostRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(postItem: Post) {
            with(binding) {
                binding.titlePost.text = postItem.title
                binding.bodyPost.text = postItem.body
            }
        }
    }


}