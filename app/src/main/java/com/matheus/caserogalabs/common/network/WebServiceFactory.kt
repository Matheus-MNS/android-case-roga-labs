package com.matheus.caserogalabs.common.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object WebServiceFactory {

    inline fun <reified T> getRetrofitInstance(url: String): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }
}