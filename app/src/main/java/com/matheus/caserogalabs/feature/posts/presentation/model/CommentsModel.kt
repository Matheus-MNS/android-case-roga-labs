package com.matheus.caserogalabs.feature.posts.presentation.model

data class CommentsModel(
    var postId: Int,
    var id: Int,
    var name: String,
    var email: String,
    var body: String
)
