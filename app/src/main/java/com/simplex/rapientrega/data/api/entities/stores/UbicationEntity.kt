package com.simplex.rapientrega.data.api.entities.stores

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UbicationEntity {
    @SerializedName("latitude")
    @Expose
    var latitude: Double = 0.0

    @SerializedName("longitude")
    @Expose
    var longitude: Double = 0.0

    constructor(latitude: Double, longitude: Double) {
        this.latitude = latitude
        this.longitude = longitude
    }

    constructor()

}