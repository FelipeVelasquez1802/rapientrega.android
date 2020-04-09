package com.simplex.rapientrega.data.api.entities.stores

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StoreBodyEntity(
    @SerializedName("city")
    @Expose
    val city: String,
    @SerializedName("ubication")
    @Expose
    val ubication: UbicationEntity
)