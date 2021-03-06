package com.simplex.rapientrega.data.api

import com.simplex.rapientrega.data.api.entities.*
import com.simplex.rapientrega.data.api.entities.orders.GeneralOrderEntity
import com.simplex.rapientrega.data.api.entities.shoppingcart.PayEntity
import com.simplex.rapientrega.data.api.entities.shoppingcart.PayResponseEntity
import com.simplex.rapientrega.data.api.entities.stores.StoreBodyEntity
import retrofit2.Call
import retrofit2.http.*

interface ApiDao {
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

    @POST("stores-ms/api/stores/city/")
    fun storesPost(@Body storeBodyEntity: StoreBodyEntity): Call<CategoryEntity>

    @GET("stores-ms/api/products/store/{store_id}")
    fun products(@Path("store_id") storeId: Int): Call<ProductKeyEntity>

    @Headers("Content-Type: application/json")
    @POST("orders-ms/api/order/create")
    fun payProducts(@Body payEntity: PayEntity): Call<PayResponseEntity>

    @FormUrlEncoded
    @POST("orders-ms/api/order/orders_by_user_id")
    fun orders(@Field("user_id") userId: Int): Call<GeneralOrderEntity>
}