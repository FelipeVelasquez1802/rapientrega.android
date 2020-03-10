package com.simplex.rapientrega.domain.tools

import com.google.android.material.textfield.TextInputLayout

fun emptyField(field: TextInputLayout): Boolean {
    var string = field.editText?.text.toString()
    return string == null || string.equals("", ignoreCase = true)
}

class ValidationFields {

    private val EMAIL_REGEX =
        "^[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\$"

    fun isEmail(email: String): Boolean {
        return EMAIL_REGEX.toRegex().matches(email)
    }
}