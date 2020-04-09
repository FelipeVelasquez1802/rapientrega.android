package com.simplex.rapientrega.data.api.entities.orders

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simplex.rapientrega.data.api.entities.ProductEntity
import com.simplex.rapientrega.data.api.entities.ProfileEntity
import com.simplex.rapientrega.data.api.entities.StoreEntity
import com.simplex.rapientrega.domain.tools.COUNT_PRODUCT
import com.simplex.rapientrega.domain.tools.ORDER_NUMBER
import java.io.Serializable

class OrderEntity(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("city")
    @Expose
    val city: String,
    @SerializedName("address")
    @Expose
    val address: String,
    @SerializedName("latitude")
    @Expose
    val latitude: String,
    @SerializedName("longitude")
    @Expose
    val longitude: String,
    @SerializedName("stores")
    @Expose
    val store: List<StoreEntity>,
    @SerializedName("products")
    @Expose
    val products: List<ProductEntity>,
    @SerializedName("user")
    @Expose
    val user: ProfileEntity,
    @SerializedName("delivery_earning")
    @Expose
    val deliveryEarning: Double,
    @SerializedName("price")
    @Expose
    val price: Double,
    @SerializedName("total_payment")
    @Expose
    val totalPayment: Double,
    @SerializedName("payment_method")
    @Expose
    val paymentMethod: String,
    @SerializedName("delivery_transport")
    @Expose
    val deliveryTransport: String,
    @SerializedName("state")
    @Expose
    val state: String
) : Serializable {
    fun idString(): String {
        return "$ORDER_NUMBER $id"
    }

    fun countProduct(): String {
        val count = products.map { it.quantity }.sum()
        return "$COUNT_PRODUCT $count"
    }
}