package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

class OrderEntity : Serializable {
    @SerializedName("productos")
    @Expose
    lateinit var products: List<ShoppingCartEntity>
    @SerializedName("date")
    @Expose
    lateinit var date: Date

    fun totalPrice(): Double {
        return products.map { it.product.price * it.count }.sum()
    }
}