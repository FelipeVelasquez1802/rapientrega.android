package com.simplex.rapientrega.tools

import com.google.gson.Gson
import java.text.NumberFormat
import java.util.*

const val BASE_URL = "http://rapientrega.co/"
const val STORES_MS = "stores-ms/"
const val PROVIDER: String = "Provider"
const val STORES = "stores"
var GSON: Gson = Gson()
var FORMAT_PRICE: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
const val ERROR_LOGIN = "error_login"
const val ERROR = "error"
const val USER = "user"
const val LIST_EMPTY = "list_empty"