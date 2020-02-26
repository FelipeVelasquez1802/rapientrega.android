package com.simplex.rapientrega.api

import retrofit2.Retrofit

private const val BASE_URL = "http://rapientrega.co/"

class RepositoryImpl {
    fun service(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiInterface::class.java)
    }
}