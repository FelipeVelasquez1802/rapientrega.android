package com.simplex.rapientrega.domain.tools

import com.google.gson.Gson
import java.text.NumberFormat
import java.util.*

const val KEY = "data"
const val BASE_URL = "http://rapientrega.co/"
const val STORES_MS = "stores-ms/"
const val PROVIDER: String = "Provider"
const val STORES = "stores"
const val PRODUCTS = "products"
const val PRODUCT = "product"
const val SHOW = "show"
const val HIDE = "hide"
const val STORE_ID = "store_id"
var GSON: Gson = Gson()
var FORMAT_PRICE: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
const val ERROR_LOGIN = "error_login"
const val ERROR_REGISTER = "error_register"
const val NOT_FOUND = "not_found"
const val SERVER_BROKEN = "server_broken"
const val UNKNOWN_ERROR = "unknown_error"
const val ERROR = "error"
const val USER = "user"
const val SHOPPING_CART = "shopping_cart"
const val ORDER = "order"
const val LIST_EMPTY = "list_empty"
const val SUCCESS_REGISTER_USER = "success_register_user"

const val USERNAME = "username"
const val EMAIL = "email"
const val PASSWORD = "password"
const val PASSWORD_REPEAT = "password_confirm"
const val IDENTIFICATION_CARD = "identification_card"
const val CELLPHONE = "cellphone"