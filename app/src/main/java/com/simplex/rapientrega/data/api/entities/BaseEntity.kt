package com.simplex.rapientrega.data.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simplex.rapientrega.domain.tools.BASE_URL
import com.simplex.rapientrega.domain.tools.STORES_MS
import java.io.Serializable

open class BaseEntity : Serializable {
    @SerializedName("id")
    @Expose
    val id: Int = 0

    @SerializedName("name")
    @Expose
    lateinit var name: String

    @SerializedName("image")
    @Expose
    val image: String? = null

    @SerializedName("is_active")
    @Expose
    val isActive: Boolean = false

    fun imageAbsolute(): String {
        return "$BASE_URL${STORES_MS}media/${image}"
    }
}