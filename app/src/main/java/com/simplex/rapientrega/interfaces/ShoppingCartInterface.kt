package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.api.entities.ShoppingCartEntity
import com.simplex.rapientrega.objects.ShoppingCart

interface ShoppingCartInterface {
    interface View {
        fun hideIncludeShoppingCart()
        fun addAdapter()
        fun showResult(result: Double)
        fun showShoppingCarts(products: List<ShoppingCartEntity>)
    }

    interface Presenter {
        fun hideIncludeShoppingCart()
        fun addAdapter()
        fun showResult(result: Double)
        fun calculateResult(shoppingCarts: List<ShoppingCartEntity>)
        fun showShoppingCarts(products: List<ShoppingCartEntity>)
        fun consultShoppingCarts(string: String?)
    }

    interface Model {
        fun calculateResult(shoppingCarts: List<ShoppingCartEntity>)
        fun consultShoppingCarts(string: String?)
    }
}