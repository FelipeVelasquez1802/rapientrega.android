package com.simplex.rapientrega.model.activities

import com.simplex.rapientrega.interfaces.ShoppingCartInterface
import com.simplex.rapientrega.objects.ShoppingCart
import com.simplex.rapientrega.tests.ShoppingCartTest

class ShoppingCartModel(
    private val presenter: ShoppingCartInterface.Presenter
) : ShoppingCartInterface.Model {

    override fun calculateResult(shoppingCarts: List<ShoppingCart>) {
        presenter.showResult(shoppingCarts.map { it.product.price * it.count }.sum())
    }

    override fun consultShoppingCarts() {
        presenter.showShoppingCarts(ShoppingCartTest().shoppingCartList())
    }

}