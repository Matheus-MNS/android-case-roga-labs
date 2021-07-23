package com.matheus.caserogalabs.feature.posts.di

import com.matheus.caserogalabs.feature.posts.presentation.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userPostPresentationModule = module {

    viewModel {
        PostsViewModel(
            postRemoteDataSource = get()
        )
    }
}