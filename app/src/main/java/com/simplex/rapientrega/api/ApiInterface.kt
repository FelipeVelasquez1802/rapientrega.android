package com.simplex.rapientrega.api

import com.simplex.rapientrega.api.entities.LoginEntity
import com.simplex.rapientrega.api.entities.StoreCategoryEntity
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("users-ms/api/rest-users/login/")
    fun login(
        @Field("login") login: String,
        @Field("password") password: String
    ): Call<LoginEntity>

    @FormUrlEncoded
    @GET("stores-ms/api/stores/")
    fun stores(): Call<StoreCategoryEntity>
}