package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StoreCategoryEntity : BaseEntity() {
    @SerializedName("stores")
    @Expose
    lateinit var stores: List<StoreEntity>
}