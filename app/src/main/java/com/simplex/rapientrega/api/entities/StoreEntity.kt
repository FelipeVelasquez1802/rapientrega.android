package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simplex.rapientrega.tools.BASE_URL
import com.simplex.rapientrega.tools.STORES_MS

class StoreEntity {
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("store_category_id")
    @Expose
    var storeCategoryId: Int = 0
    @SerializedName("name")
    @Expose
    lateinit var name: String
    @SerializedName("image")
    @Expose
    lateinit var image: String
    @SerializedName("description")
    @Expose
    lateinit var description: String
    @SerializedName("working_days")
    @Expose
    lateinit var workingDays: String
    @SerializedName("opening_time")
    @Expose
    lateinit var openingTime: String
    @SerializedName("closing_time")
    @Expose
    lateinit var closingTime: String
    @SerializedName("cost_of_shipping")
    @Expose
    var costOfShipping: Double = 0.0
    @SerializedName("is_active")
    @Expose
    var isActive: Boolean = false

    fun imageAbsolute(): String {
        return "$BASE_URL${STORES_MS}media/${image}"
    }
}