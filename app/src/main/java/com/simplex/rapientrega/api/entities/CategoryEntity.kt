package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoryEntity {
    @SerializedName("stores_categories")
    @Expose
    lateinit var storesCategories: List<StoreCategoryEntity>
}