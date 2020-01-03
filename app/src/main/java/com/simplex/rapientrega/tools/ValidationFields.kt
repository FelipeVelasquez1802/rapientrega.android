package com.simplex.rapientrega.tools

import com.google.android.material.textfield.TextInputLayout

fun emptyField(field: TextInputLayout): Boolean {
    var string = field.editText?.text.toString()
    return string == null || string.equals("", ignoreCase = true)
}