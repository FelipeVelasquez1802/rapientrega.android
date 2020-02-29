package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProfileEntity : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("is_superuser")
    @Expose
    var isSuperUser: Boolean = false
    @SerializedName("username")
    @Expose
    lateinit var username: String
    @SerializedName("email")
    @Expose
    lateinit var email: String
}