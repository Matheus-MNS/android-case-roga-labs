package com.matheus.caserogalabs.feature.posts.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheus.caserogalabs.feature.posts.presentation.model.PostModel
import com.matheus.caserogalabs.feature.posts.presentation.mapper.PostsMapper
import com.matheus.caserogalabs.feature.posts.data.remote.data_source.PostRemoteDataSource
import com.matheus.caserogalabs.feature.posts.presentation.mapper.CommentsMapper
import com.matheus.caserogalabs.feature.posts.data.remote.model.CommentsResponse
import com.matheus.caserogalabs.feature.posts.data.remote.model.PostResponse
import com.matheus.caserogalabs.feature.posts.presentation.model.CommentsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val ERROR = "Erro ao acessar a Api"

class PostsViewModel(
    private val postRemoteDataSource: PostRemoteDataSource
) : ViewModel() {

    val postList: MutableLiveData<List<PostModel>> by lazy {
        MutableLiveData<List<PostModel>>()
    }

    val commentsList: MutableLiveData<List<CommentsModel>> by lazy {
        MutableLiveData<List<CommentsModel>>()
    }

    val error: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        //getPosts()
    }

//    private fun getPosts() {
//        postRemoteDataSource.getPosts().enqueue(
//            object : Callback<List<PostResponse>> {
//                override fun onResponse(
//                    call: Call<List<PostResponse>>,
//                    response: Response<List<PostResponse>>
//                ) {
//                    postList.value = PostsMapper.toPresentation(response.body())
//                }
//
//                override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
//                    error.value = ERROR
//                }
//            }
//        )
//    }
//
//    fun getPostComments(postId: Int) {
//        postRemoteDataSource.getPostComments(postId).enqueue(
//            object : Callback<List<CommentsResponse>> {
//                override fun onResponse(
//                    call: Call<List<CommentsResponse>>,
//                    response: Response<List<CommentsResponse>>
//                ) {
//                    commentsList.value = CommentsMapper.toPresentation(response.body())
//                }
//
//                override fun onFailure(call: Call<List<CommentsResponse>>, t: Throwable) {
//                    error.value = ERROR
//                }
//            }
//        )
//    }
}