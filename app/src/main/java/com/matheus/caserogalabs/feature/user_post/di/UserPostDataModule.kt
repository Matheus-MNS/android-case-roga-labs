package com.matheus.caserogalabs.feature.user_post.di

import com.matheus.caserogalabs.common.network.BASE_URL
import com.matheus.caserogalabs.common.network.WebServiceFactory
import com.matheus.caserogalabs.feature.user_post.data.remote.api.PostsService
import com.matheus.caserogalabs.feature.user_post.data.remote.data_source.PostRemoteDataSource
import org.koin.dsl.module

val userPostDataModule = module {

    single {
        WebServiceFactory.getRetrofitInstance(BASE_URL) as PostsService
    }

    factory {
        PostRemoteDataSource(
            service = get()
        )
    }
}