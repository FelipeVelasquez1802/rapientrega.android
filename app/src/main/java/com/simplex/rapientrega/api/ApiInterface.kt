package com.simplex.rapientrega.api

import com.simplex.rapientrega.api.responses.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("users-ms/login/")
    fun login(
        @Field("login") login: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}