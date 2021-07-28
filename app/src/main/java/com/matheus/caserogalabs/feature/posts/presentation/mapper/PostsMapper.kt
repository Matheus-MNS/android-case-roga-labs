package com.matheus.caserogalabs.feature.posts.presentation.mapper

import com.matheus.caserogalabs.feature.posts.presentation.model.PostModel
import com.matheus.caserogalabs.feature.posts.data.remote.model.PostResponse

object PostsMapper {

    fun toPresentation(postResponseList: List<PostResponse>?): List<PostModel> {
        return if (postResponseList.isNullOrEmpty()) {
            emptyList()
        } else {
            parsePostList(postResponseList)
        }
    }

    private fun parsePostList(postResponseList: List<PostResponse>): List<PostModel> =
        postResponseList.map {
            PostModel(
                userId = it.userId ?: 0,
                id = it.id ?: 0,
                title = it.title ?: "",
                body = it.body ?: ""
            )
        }
}