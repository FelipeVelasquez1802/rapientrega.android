package com.simplex.rapientrega.data.api.entities.shoppingcart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PayEntity(
    @SerializedName("city")
    @Expose
    val city: String,
    @SerializedName("address")
    @Expose
    val address: String,
    @SerializedName("stores")
    @Expose
    val stores: List<StoresEntity>,
    @SerializedName("user_id")
    @Expose
    val userId: Int,
    @SerializedName("order_ubication")
    @Expose
    val orderUbication: OrderUbicationEntity,
    @SerializedName("payment_method")
    @Expose
    val paymentMethod: String
)