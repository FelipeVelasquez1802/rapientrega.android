package com.simplex.rapientrega.data.api.entities.shoppingcart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PayResponseEntity(
    @SerializedName("order_id")
    @Expose
    val orderId: Int,
    @SerializedName("created")
    @Expose
    val created: Boolean,
    @SerializedName("error")
    @Expose
    val error: Boolean
)