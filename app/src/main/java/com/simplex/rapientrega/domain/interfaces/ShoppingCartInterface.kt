package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.ShoppingCartEntity

interface ShoppingCartInterface {
    interface View {
        fun hideIncludeShoppingCart()
        fun addAdapter()
        fun showResult(result: Double)
        fun showShoppingCarts(products: List<ShoppingCartEntity>)
        fun saveProducts(string: String?)
        fun deleteProducts()
        fun goMainActivity()
        fun showMessage(id: Int)
    }

    interface Presenter {
        fun hideIncludeShoppingCart()
        fun addAdapter()
        fun showResult(result: Double)
        fun calculateResult(shoppingCarts: List<ShoppingCartEntity>)
        fun showShoppingCarts(products: List<ShoppingCartEntity>)
        fun consultShoppingCarts(string: String?)
        fun convertProducts(products: List<ShoppingCartEntity>, list: String?)
        fun saveProducts(string: String?)
    }

    interface Model {
        fun calculateResult(shoppingCarts: List<ShoppingCartEntity>)
        fun consultShoppingCarts(string: String?)
        fun convertProducts(products: List<ShoppingCartEntity>, list: String?)
    }
}