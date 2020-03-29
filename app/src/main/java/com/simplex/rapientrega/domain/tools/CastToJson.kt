package com.simplex.rapientrega.domain.tools

import com.google.gson.Gson
import com.simplex.rapientrega.data.api.entities.LoginEntity
import com.simplex.rapientrega.data.api.entities.OrderEntity
import com.simplex.rapientrega.data.api.entities.RegisterErrorEntity
import com.simplex.rapientrega.data.api.entities.shoppingcart.ShoppingCartEntity

fun objectToString(any: Any): String {
    return GSON.toJson(any)
}

fun toLoginEntity(string: String): LoginEntity {
    return Gson().fromJson(string, LoginEntity::class.java)
}

fun toListProduct(string: String?): List<ShoppingCartEntity> {
    return if (string != null) Gson().fromJson(
        string, Array<ShoppingCartEntity>::class.java
    ).toList()
    else emptyList()
}

fun toListShoppingCart(string: String?): List<ShoppingCartEntity> {
    return if (string != null) Gson().fromJson(
        string, Array<ShoppingCartEntity>::class.java
    ).toList()
    else emptyList()
}

fun toListOrder(string: String?): List<OrderEntity> {
    return if (string != null) Gson().fromJson(
        string, Array<OrderEntity>::class.java
    ).toList()
    else emptyList()
}

fun toRegisterError(string: String?): RegisterErrorEntity? {
    return if (string != null) Gson().fromJson(
        string, RegisterErrorEntity::class.java
    )
    else null
}