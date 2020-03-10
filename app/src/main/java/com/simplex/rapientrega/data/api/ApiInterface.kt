package com.simplex.rapientrega.data.api

import com.simplex.rapientrega.data.api.entities.*
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @FormUrlEncoded
    @POST("users-ms/api/rest-users/login/")
    fun login(
        @Field("login") login: String,
        @Field("password") password: String
    ): Call<LoginEntity>

    @Headers("Content-Type: application/json")
    @POST("users-ms/api/rest-users/signup/")
    fun signup(@Body registerEntity: RegisterEntity): Call<ProfileEntity>

    @GET("stores-ms/api/stores/")
    fun stores(): Call<CategoryEntity>

    @GET("stores-ms/api/products/")
    fun products(): Call<ProductKeyEntity>
}