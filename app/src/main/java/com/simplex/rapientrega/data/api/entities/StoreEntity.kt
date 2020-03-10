package com.simplex.rapientrega.data.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StoreEntity : BaseEntity() {
    @SerializedName("store_category_id")
    @Expose
    var storeCategoryId: Int = 0
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

    fun serviceTime(): String {
        return "$openingTime - $closingTime"
    }
}