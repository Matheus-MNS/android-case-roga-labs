package com.matheus.caserogalabs.feature.user_post.presetantion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.caserogalabs.R
import com.matheus.caserogalabs.common.Post
import com.matheus.caserogalabs.databinding.FragmentUserPostBinding
import com.matheus.caserogalabs.feature.user_post.presetantion.adapter.UserPostAdapter

class UserPostFragment : Fragment() {

    private lateinit var binding: FragmentUserPostBinding
    private lateinit var userPostAdapter: UserPostAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userPostAdapter = UserPostAdapter(Post.DUMLIST)
        binding.userPostReclycerView.adapter = userPostAdapter
    }
}