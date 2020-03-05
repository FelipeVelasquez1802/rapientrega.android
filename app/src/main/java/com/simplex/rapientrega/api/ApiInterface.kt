package com.simplex.rapientrega.api

import com.simplex.rapientrega.api.entities.CategoryEntity
import com.simplex.rapientrega.api.entities.LoginEntity
import com.simplex.rapientrega.api.entities.ProductKeyEntity
import com.simplex.rapientrega.api.entities.ProfileEntity
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
    @POST("users-ms/api/rest-users/signup/")
    fun signup(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("password_confirm") passwordConfirm: String,
        @Field("identification_card") identificationCard: String,
        @Field("cellphone") cellphone: String
    ): Call<ProfileEntity>

    @GET("stores-ms/api/stores/")
    fun stores(): Call<CategoryEntity>

    @GET("stores-ms/api/products/")
    fun products(): Call<ProductKeyEntity>
}