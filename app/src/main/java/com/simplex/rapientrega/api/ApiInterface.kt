package com.simplex.rapientrega.api

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiInterface {
    @POST("users-ms/login/")
    fun login(
        @Field("login") login: String,
        @Field("password") password: String
    ): Call<List<String>>
}