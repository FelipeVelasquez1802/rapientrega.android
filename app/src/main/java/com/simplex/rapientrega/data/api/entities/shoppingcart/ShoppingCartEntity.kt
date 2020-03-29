package com.simplex.rapientrega.data.api.entities.shoppingcart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simplex.rapientrega.data.api.entities.ProductEntity
import java.io.Serializable

class ShoppingCartEntity : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("prouct")
    @Expose
    lateinit var product: ProductEntity
    @SerializedName("count")
    @Expose
    var count: Int = 0
}