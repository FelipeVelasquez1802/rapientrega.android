package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginEntity {
    @SerializedName("detail")
    @Expose
    lateinit var detail: String
    @SerializedName("token")
    @Expose
    lateinit var token: String
    @SerializedName("profile")
    @Expose
    lateinit var profile: ProfileEntity
}