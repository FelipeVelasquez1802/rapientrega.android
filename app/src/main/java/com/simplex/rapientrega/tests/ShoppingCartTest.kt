package com.simplex.rapientrega.tests

import com.simplex.rapientrega.objects.ShoppingCart

class ShoppingCartTest {
    fun shoppingCartList(): List<ShoppingCart> {
        var shoppingCarts = ArrayList<ShoppingCart>()
        shoppingCarts.add(
            ShoppingCart(
                ProductTest().productList()[0],
                2
            )
        )
        shoppingCarts.add(
            ShoppingCart(
                ProductTest().productList()[1],
                20
            )
        )
        return shoppingCarts
    }
}