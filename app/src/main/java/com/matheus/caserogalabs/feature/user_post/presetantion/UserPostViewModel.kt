package com.matheus.caserogalabs.feature.user_post.presetantion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheus.caserogalabs.feature.user_post.data.model.PostModel
import com.matheus.caserogalabs.feature.user_post.data.remote.mapper.PostMapper
import com.matheus.caserogalabs.feature.user_post.data.remote.model.PostRemoteDataSource
import com.matheus.caserogalabs.feature.user_post.data.remote.model.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserPostViewModel(
    private val postRemoteDataSource: PostRemoteDataSource

) : ViewModel(){

    val postList:MutableLiveData<List<PostModel>> by lazy {
        MutableLiveData<List<PostModel>>()
    }

    val error: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    init {
        getPost()
    }


    private fun getPost(){
        val callback = postRemoteDataSource.getPost()
        callback.enqueue(object : Callback<List<PostResponse>>{
            override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                error.value = true
            }

            override fun onResponse(
                call: Call<List<PostResponse>>,
                response: Response<List<PostResponse>>
            ) {
                postList.value = PostMapper.toDomain(response.body())
            }
        })

    }
}