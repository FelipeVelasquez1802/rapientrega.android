package com.simplex.rapientrega.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterEntity {
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

    @SerializedName("password")
    @Expose
    lateinit var password: String

    @SerializedName("password_confirm")
    @Expose
    lateinit var passwordRepeat: String

    @SerializedName("identification_card")
    @Expose
    lateinit var identificationCard: String

    @SerializedName("cellphone")
    @Expose
    lateinit var cellphone: String
}