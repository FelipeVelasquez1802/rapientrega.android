package com.simplex.rapientrega.data.api.entities.orders

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GeneralOrderEntity(
    @SerializedName("orders")
    @Expose
    val orders: List<OrderEntity>
)