package com.simplex.rapientrega.tools

import com.google.gson.Gson
import java.text.NumberFormat
import java.util.*

const val PROVIDER: String = "Provider"

var GSON: Gson = Gson()
var FORMAT_PRICE: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)

const val ERROR_LOGIN = "error_login"
const val ERROR = "error"
const val USER = "user"