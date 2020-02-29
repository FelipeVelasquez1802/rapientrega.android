package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simplex.rapientrega.tools.BASE_URL
import com.simplex.rapientrega.tools.STORES_MS
import java.io.Serializable

open class BaseEntity : Serializable {
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

    fun imageAbsolute(): String {
        return "$BASE_URL${STORES_MS}media/${image}"
    }
}