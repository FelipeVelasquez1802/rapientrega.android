package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProductEntity : BaseEntity() {
    @SerializedName("product_category_id")
    @Expose
    var productCategoryId: Int = 0
    @SerializedName("description")
    @Expose
    lateinit var description: String
    @SerializedName("price")
    @Expose
    var price: Double = 0.0
    @SerializedName("images")
    @Expose
    lateinit var images: List<String>
}