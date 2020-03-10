package com.simplex.rapientrega.data.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoginEntity : Serializable {
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