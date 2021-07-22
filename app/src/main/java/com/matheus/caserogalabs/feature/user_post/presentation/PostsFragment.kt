package com.matheus.caserogalabs.feature.user_post.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.matheus.caserogalabs.databinding.FragmentPostsBinding
import com.matheus.caserogalabs.feature.user_post.presentation.model.PostModel
import com.matheus.caserogalabs.feature.user_post.presentation.adapter.PostsAdapter
import com.matheus.caserogalabs.feature.user_post.presentation.model.CommentsModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostsFragment : Fragment() {

    private lateinit var binding: FragmentPostsBinding
    private lateinit var postsAdapter: PostsAdapter
    private lateinit var clickedPostTitle: String
    private val viewModel: PostsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleObserver()
    }

    private fun handleObserver() {
        viewModel.postList.observe(
            viewLifecycleOwner, Observer(
                ::handleRecyclerView
            )
        )
        viewModel.commentsList.observe(
            viewLifecycleOwner, Observer(
                ::handleComments
            )
        )
    }

    private fun handleComments(list: List<CommentsModel>) {
        val commentsDialog = CommentsDialogFragment()
        commentsDialog.apply {
            commentsList = list
            postTitle = clickedPostTitle
        }
        activity?.supportFragmentManager?.let { commentsDialog.show(it, "comments") }
    }

    private fun handleRecyclerView(list: List<PostModel>) {
        postsAdapter = PostsAdapter(list)
        binding.userPostRecyclerView.adapter = postsAdapter
        postsAdapter.itemClickListener = {
            viewModel.getPostComments(it.first)
            clickedPostTitle = it.second
        }
    }
}