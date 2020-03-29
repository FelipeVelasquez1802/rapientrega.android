package com.simplex.rapientrega.data.api.entities.shoppingcart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OrderUbicationEntity(
    @SerializedName("user_lat")
    @Expose
    val userLat: Double,
    @SerializedName("userLgn")
    @Expose
    val userLgn: Double
)