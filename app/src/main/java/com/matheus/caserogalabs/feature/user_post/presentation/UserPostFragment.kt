package com.matheus.caserogalabs.feature.user_post.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.matheus.caserogalabs.databinding.FragmentUserPostBinding
import com.matheus.caserogalabs.feature.user_post.presentation.model.PostModel
import com.matheus.caserogalabs.feature.user_post.presentation.adapter.UserPostAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserPostFragment : Fragment() {

    private lateinit var binding: FragmentUserPostBinding
    private lateinit var userPostAdapter: UserPostAdapter
    private val viewModel: UserPostViewModel by viewModel()

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

        handleObserver()
    }

    private fun handleObserver() {
        viewModel.postList.observe(
            viewLifecycleOwner, Observer(
                ::handleRecyclerView
            )
        )
    }

    private fun handleRecyclerView(list: List<PostModel>) {
        userPostAdapter = UserPostAdapter(list)
        binding.userPostRecyclerView.adapter = userPostAdapter
        userPostAdapter.itemClickListener = { postId ->
            Toast.makeText(context, "$postId", Toast.LENGTH_LONG).show()
        }
    }
}