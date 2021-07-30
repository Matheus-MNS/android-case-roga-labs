package com.matheus.caserogalabs.feature.posts.data.remote.data_source

import com.matheus.caserogalabs.feature.posts.data.remote.service.PostsService

 class PostRemoteDataSource(private val service: PostsService) {
    suspend fun getPosts() = service.getPosts()
    suspend fun getPostComments(postId: Int) = service.getPostComments(postId)
}