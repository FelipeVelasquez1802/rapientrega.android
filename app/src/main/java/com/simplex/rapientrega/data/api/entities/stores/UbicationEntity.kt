package com.simplex.rapientrega.data.api.entities.stores

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UbicationEntity(
    @SerializedName("latitude")
    @Expose
    val latitude: Double,
    @SerializedName("longitude")
    @Expose
    val longitude: Double
)