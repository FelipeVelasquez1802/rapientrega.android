package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.objects.ShoppingCart

interface ShoppingCartInterface {
    interface View {
        fun hideIncludeShoppingCart()
        fun addAdapter()
        fun showResult(result: Double)
        fun showShoppingCarts(shoppingCarts: List<ShoppingCart>)
    }

    interface Presenter {
        fun hideIncludeShoppingCart()
        fun addAdapter()
        fun showResult(result: Double)
        fun calculateResult(shoppingCarts: List<ShoppingCart>)
        fun showShoppingCarts(shoppingCarts: List<ShoppingCart>)
        fun consultShoppingCarts()
    }

    interface Model {
        fun calculateResult(shoppingCarts: List<ShoppingCart>)
        fun consultShoppingCarts()
    }
}