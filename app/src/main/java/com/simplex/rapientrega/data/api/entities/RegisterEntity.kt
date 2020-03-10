package com.simplex.rapientrega.data.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterEntity(
    @SerializedName("username")
    @Expose
    val username: String,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("password")
    @Expose
    val password: String,
    @SerializedName("password_confirm")
    @Expose
    val passwordRepeat: String,
    @SerializedName("identification_card")
    @Expose
    val identificationCard: String,
    @SerializedName("cellphone")
    @Expose
    val cellphone: String
)