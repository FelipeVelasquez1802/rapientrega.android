package com.simplex.rapientrega.api

import com.simplex.rapientrega.api.entities.*
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @FormUrlEncoded
    @POST("users-ms/api/rest-users/login/")
    fun login(
        @Field("login") login: String,
        @Field("password") password: String
    ): Call<LoginEntity>

    @FormUrlEncoded
    @POST("users-ms/api/rest-users/signup/")
    fun signup(@Body registerEntity: RegisterEntity): Call<ProfileEntity>
//    fun signup(
//        @Field("username") username: String,
//        @Field("email") email: String,
//        @Field("password") password: String,
//        @Field("password_confirm") passwordConfirm: String,
//        @Field("identification_card") identificationCard: String,
//        @Field("cellphone") cellphone: String
//    ): Call<ProfileEntity>

    @GET("stores-ms/api/stores/")
    fun stores(): Call<CategoryEntity>

    @GET("stores-ms/api/products/")
    fun products(): Call<ProductKeyEntity>
}