package com.simplex.rapientrega.tools

import com.simplex.rapientrega.objects.Provider


fun toListProvider(string: String): ArrayList<Provider> {
    val list = ArrayList<Provider>()
    list.addAll(GSON.fromJson(string, Array<Provider>::class.java).toList())
    return list
}