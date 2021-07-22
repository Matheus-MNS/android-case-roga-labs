package com.matheus.caserogalabs.feature.user_post.di

import com.matheus.caserogalabs.feature.user_post.presentation.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userPostPresentationModule = module {

    viewModel {
        PostsViewModel(
            postRemoteDataSource = get()
        )
    }
}