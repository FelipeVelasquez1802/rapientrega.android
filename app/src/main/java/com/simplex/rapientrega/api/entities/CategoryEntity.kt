package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CategoryEntity : Serializable {
    @SerializedName("stores_categories")
    @Expose
    lateinit var storesCategories: List<StoreCategoryEntity>
}