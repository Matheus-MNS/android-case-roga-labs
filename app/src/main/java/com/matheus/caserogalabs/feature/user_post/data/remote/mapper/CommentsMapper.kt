package com.matheus.caserogalabs.feature.user_post.data.remote.mapper

import com.matheus.caserogalabs.feature.user_post.data.remote.model.CommentsResponse
import com.matheus.caserogalabs.feature.user_post.presentation.model.CommentsModel

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
                body = it.body ?: "",
            )
        }
}