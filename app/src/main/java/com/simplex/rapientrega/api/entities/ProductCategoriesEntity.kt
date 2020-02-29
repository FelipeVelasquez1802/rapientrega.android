package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductCategoriesEntity : BaseEntity() {
    @SerializedName("store_id")
    @Expose
    var storeId: Int = 0
    @SerializedName("products")
    @Expose
    lateinit var products: List<ProductEntity>
}