package com.simplex.rapientrega.api

import com.simplex.rapientrega.api.entities.CategoryEntity
import com.simplex.rapientrega.api.entities.LoginEntity
import com.simplex.rapientrega.api.entities.ProductKeyEntity
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

    @GET("stores-ms/api/stores/")
    fun stores(): Call<CategoryEntity>

    @GET("stores-ms/api/products/")
    fun products(): Call<ProductKeyEntity>
}