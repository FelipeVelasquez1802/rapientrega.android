package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StoreCategoryEntity {
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("name")
    @Expose
    lateinit var name: String
    @SerializedName("image")
    @Expose
    lateinit var image: String
    @SerializedName("is_active")
    @Expose
    var isActive: Boolean = false
    @SerializedName("stores")
    @Expose
    lateinit var stores: List<StoreEntity>
}