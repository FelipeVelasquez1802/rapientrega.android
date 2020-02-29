package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductKeyEntity {
    @SerializedName("product_categories")
    @Expose
    lateinit var productCategories: List<ProductCategoriesEntity>
}