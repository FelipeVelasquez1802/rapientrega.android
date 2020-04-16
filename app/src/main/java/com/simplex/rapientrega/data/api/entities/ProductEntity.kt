package com.simplex.rapientrega.data.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductEntity : BaseEntity() {
    @SerializedName("product_category_id")
    @Expose
    var productCategoryId: Int = 0

    @SerializedName("store_id")
    @Expose
    var storeId: Int = 0

    @SerializedName("description")
    @Expose
    lateinit var description: String

    @SerializedName("price")
    @Expose
    var price: Double = 0.0

    @SerializedName("images")
    @Expose
    lateinit var images: List<String>

    @SerializedName("identification_card")
    @Expose
    lateinit var identificationCard: String

    @SerializedName("cellphone")
    @Expose
    lateinit var cellphone: String

    @SerializedName("quantity")
    @Expose
    var quantity: Int = 0

}