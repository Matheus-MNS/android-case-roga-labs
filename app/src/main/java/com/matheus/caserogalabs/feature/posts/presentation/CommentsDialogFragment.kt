package com.matheus.caserogalabs.feature.posts.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.matheus.caserogalabs.databinding.DialogCommentsBinding
import com.matheus.caserogalabs.feature.posts.presentation.adapter.PostCommentsAdapter
import com.matheus.caserogalabs.feature.posts.presentation.model.CommentsModel

class CommentsDialogFragment : DialogFragment() {

    private lateinit var binding: DialogCommentsBinding
    var postTitle: String = ""
    var commentsList: List<CommentsModel> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogCommentsBinding.inflate(inflater, container, false)
        setWindowFeatures()
        return binding.root
    }

    private fun setWindowFeatures() {
        dialog?.apply {

            window?.decorView?.setBackgroundResource(android.R.color.transparent)
            val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
            val height = (resources.displayMetrics.heightPixels * 0.85).toInt()
            window?.setLayout(
                width,
                height
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.postTitle.text = postTitle
        handleRecyclerView()
    }

    private fun handleRecyclerView() {
        val commentaryAdapter = PostCommentsAdapter(commentsList)
        binding.dialogFragmentRecyclerView.adapter = commentaryAdapter
    }
}