package com.matheus.caserogalabs.feature.user_post.data.remote.model

import com.matheus.caserogalabs.feature.user_post.data.remote.api.RogaLabsService

class PostRemoteDataSource (private val rogaLabsService: RogaLabsService){
    fun getPost() = rogaLabsService.getFacts()
}