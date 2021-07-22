package com.matheus.caserogalabs.feature.user_post.data.remote.model

import com.google.gson.annotations.SerializedName

data class CommentsResponse(
    @SerializedName("PostId")
    val postId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("body")
    val body: String?

)
