package com.simplex.rapientrega.tools

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.security.Provider
import java.text.NumberFormat
import java.util.*

var PROVIDER: String = "Provider"
var PROVIDER_TYPE = object : TypeToken<List<Provider>>() {}.type

var GSON: Gson = Gson()
var FORMAT_PRICE: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)