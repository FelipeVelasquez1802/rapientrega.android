package com.simplex.rapientrega.data.api.entities.shoppingcart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductPayEntity(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("cant")
    @Expose
    val count: Int
)