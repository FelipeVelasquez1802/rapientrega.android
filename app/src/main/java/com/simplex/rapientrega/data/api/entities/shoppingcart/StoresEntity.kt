package com.simplex.rapientrega.data.api.entities.shoppingcart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StoresEntity(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("products")
    @Expose
    val products: ArrayList<ProductPayEntity>
)