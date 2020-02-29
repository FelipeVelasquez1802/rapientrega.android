package com.simplex.rapientrega.model.activities

import com.simplex.rapientrega.api.entities.ShoppingCartEntity
import com.simplex.rapientrega.interfaces.ShoppingCartInterface
import com.simplex.rapientrega.tools.toListShoppingCart

class ShoppingCartModel(
    private val presenter: ShoppingCartInterface.Presenter
) : ShoppingCartInterface.Model {

    override fun calculateResult(shoppingCarts: List<ShoppingCartEntity>) {
        presenter.showResult(shoppingCarts.map { it.product.price * it.count }.sum())
    }

    override fun consultShoppingCarts(string: String?) {
        val shoppingCarts = toListShoppingCart(string)
        presenter.showShoppingCarts(shoppingCarts)
    }

}