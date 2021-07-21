package com.matheus.caserogalabs.feature.user_post.data.remote.api


import com.matheus.caserogalabs.feature.user_post.data.remote.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RogaLabsService {

    @GET("posts")
    fun getFacts(): Call<List<PostResponse>>
}

//@GET("posts/{post_id}/comments")
//fun getFacts(
//    @Path("post_id")postId:Int
//): Call<List<PostResponse>>