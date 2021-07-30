package com.matheus.caserogalabs.feature.posts.di

import com.matheus.caserogalabs.common.network.BASE_URL
import com.matheus.caserogalabs.common.network.WebServiceFactory
import com.matheus.caserogalabs.feature.posts.data.remote.service.PostsService
import com.matheus.caserogalabs.feature.posts.data.remote.data_source.PostRemoteDataSource
import com.matheus.caserogalabs.feature.posts.domain.Repository
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