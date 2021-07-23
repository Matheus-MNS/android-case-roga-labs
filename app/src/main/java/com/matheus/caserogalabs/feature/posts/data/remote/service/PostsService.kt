package com.matheus.caserogalabs.feature.posts.data.remote.service

import com.matheus.caserogalabs.feature.posts.data.remote.model.CommentsResponse
import com.matheus.caserogalabs.feature.posts.data.remote.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsService {

    @GET("posts")
    fun getPosts(): Call<List<PostResponse>>

    @GET("posts/{post_id}/comments")
    fun getPostComments(
        @Path("post_id")postId:Int
    ): Call<List<CommentsResponse>>
}

