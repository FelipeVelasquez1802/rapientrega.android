package com.simplex.rapientrega.data.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProductKeyEntity : Serializable {
    @SerializedName("product_categories")
    @Expose
    lateinit var productCategories: List<ProductCategoriesEntity>
}