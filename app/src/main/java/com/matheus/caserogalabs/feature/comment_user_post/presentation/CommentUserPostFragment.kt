package com.matheus.caserogalabs.feature.comment_user_post.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.caserogalabs.R
import com.matheus.caserogalabs.databinding.FragmentCommentUserPostBinding

class CommentUserPostFragment : Fragment() {

    private lateinit var binding: FragmentCommentUserPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommentUserPostBinding.inflate(inflater, container, false)
        return binding.root
    }

}