package com.matheus.caserogalabs.feature.user_post.data.remote.mapper

import com.matheus.caserogalabs.feature.user_post.data.model.PostModel
import com.matheus.caserogalabs.feature.user_post.data.remote.model.PostResponse

object PostMapper {

    fun toDomain(postResponseList: List<PostResponse>?): List<PostModel> {
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
                body = it.body ?: "",
            )
        }
}