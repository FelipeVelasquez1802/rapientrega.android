package com.simplex.rapientrega.data.api.repositories

import com.simplex.rapientrega.data.api.ApiDao
import com.simplex.rapientrega.domain.tools.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryImpl {
    fun service(): ApiDao {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        return retrofit.create(ApiDao::class.java)
    }
}