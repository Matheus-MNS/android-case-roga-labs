package com.matheus.caserogalabs.feature.posts.presentation.mapper

import com.matheus.caserogalabs.feature.posts.data.remote.model.CommentsResponse
import com.matheus.caserogalabs.feature.posts.presentation.model.CommentsModel

object CommentsMapper {

    fun toPresentation(commentaryResponseList: List<CommentsResponse>?): List<CommentsModel> {
        return if (commentaryResponseList.isNullOrEmpty()) {
            emptyList()
        } else {
            parseCommentaryList(commentaryResponseList)
        }
    }

    private fun parseCommentaryList(commentaryResponseList: List<CommentsResponse>): List<CommentsModel> =
        commentaryResponseList.map {
            CommentsModel(
                postId = it.postId ?: 0,
                id = it.id ?: 0,
                name = it.name ?: "",
                email = it.email ?: "",
                body = it.body ?: ""
            )
        }
}