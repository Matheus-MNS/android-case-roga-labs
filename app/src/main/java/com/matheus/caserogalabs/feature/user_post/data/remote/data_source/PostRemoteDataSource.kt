package com.matheus.caserogalabs.feature.user_post.data.remote.data_source

import com.matheus.caserogalabs.feature.user_post.data.remote.api.PostsService

class PostRemoteDataSource(private val service: PostsService) {
    fun getPosts() = service.getPosts()
    fun getPostComments(postId: Int) = service.getPostComments(postId)
}