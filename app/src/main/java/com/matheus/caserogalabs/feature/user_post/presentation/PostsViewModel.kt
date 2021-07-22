package com.matheus.caserogalabs.feature.user_post.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheus.caserogalabs.feature.user_post.presentation.model.PostModel
import com.matheus.caserogalabs.feature.user_post.data.remote.mapper.PostsMapper
import com.matheus.caserogalabs.feature.user_post.data.remote.data_source.PostRemoteDataSource
import com.matheus.caserogalabs.feature.user_post.data.remote.mapper.CommentsMapper
import com.matheus.caserogalabs.feature.user_post.data.remote.model.CommentsResponse
import com.matheus.caserogalabs.feature.user_post.data.remote.model.PostResponse
import com.matheus.caserogalabs.feature.user_post.presentation.model.CommentsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel(
    private val postRemoteDataSource: PostRemoteDataSource

) : ViewModel() {

    val postList: MutableLiveData<List<PostModel>> by lazy {
        MutableLiveData<List<PostModel>>()
    }

    val commentsList: MutableLiveData<List<CommentsModel>> by lazy {
        MutableLiveData<List<CommentsModel>>()
    }

    val error: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


    init {
        getPosts()
    }


    private fun getPosts() {
        postRemoteDataSource.getPosts().enqueue(
            object : Callback<List<PostResponse>> {
                override fun onResponse(
                    call: Call<List<PostResponse>>,
                    response: Response<List<PostResponse>>
                ) {
                    postList.value = PostsMapper.toPresentation(response.body())
                }

                override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                    error.value = true
                }
            }
        )
    }

    fun getPostComments(postId: Int) {
        postRemoteDataSource.getPostComments(postId).enqueue(
            object : Callback<List<CommentsResponse>> {
                override fun onResponse(
                    call: Call<List<CommentsResponse>>,
                    response: Response<List<CommentsResponse>>
                ) {
                    commentsList.value = CommentsMapper.toPresentation(response.body())
                }

                override fun onFailure(call: Call<List<CommentsResponse>>, t: Throwable) {
                    error.value = true
                }
            }
        )
    }
}