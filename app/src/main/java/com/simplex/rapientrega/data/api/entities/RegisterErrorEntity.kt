package com.simplex.rapientrega.data.api.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterErrorEntity(
    @SerializedName("username")
    @Expose
    val username: List<String>,
    @SerializedName("email")
    @Expose
    val email: List<String>,
    @SerializedName("password")
    @Expose
    val password: List<String>,
    @SerializedName("password_confirm")
    @Expose
    val passwordRepeat: List<String>,
    @SerializedName("identification_card")
    @Expose
    val identificationCard: List<String>,
    @SerializedName("cellphone")
    @Expose
    val cellphone: List<String>
) {
    private fun stringList(list: List<String>?): String? {
        if (list == null || list.isEmpty()) return null
        var string = ""
        list.forEach {
            string += it
        }
        return string
    }

    fun stringUsername(): String? {
        return stringList(username)
    }

    fun stringEmail(): String? {
        return stringList(email)
    }

    fun stringPassword(): String? {
        return stringList(password)
    }

    fun stringPasswordRepeat(): String? {
        return stringList(passwordRepeat)
    }

    fun stringIdentificationCard(): String? {
        return stringList(identificationCard)
    }

    fun stringCellphone(): String? {
        return stringList(cellphone)
    }
}