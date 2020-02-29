package com.simplex.rapientrega.tools

import com.google.gson.Gson
import com.simplex.rapientrega.api.entities.LoginEntity
import com.simplex.rapientrega.api.entities.ProfileEntity
import com.simplex.rapientrega.objects.Provider


fun toListProvider(string: String): ArrayList<Provider> {
    val list = ArrayList<Provider>()
    list.addAll(GSON.fromJson(string, Array<Provider>::class.java).toList())
    return list
}

fun objectToString(any: Any): String {
    return GSON.toJson(any)
}

fun toLoginEntity(string: String): LoginEntity {
    return Gson().fromJson(string, LoginEntity::class.java)
}