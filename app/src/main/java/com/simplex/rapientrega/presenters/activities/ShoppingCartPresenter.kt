package com.simplex.rapientrega.presenters.activities

import com.simplex.rapientrega.interfaces.ShoppingCartInterface
import com.simplex.rapientrega.model.activities.ShoppingCartModel
import com.simplex.rapientrega.objects.ShoppingCart

class ShoppingCartPresenter(
    private val view: ShoppingCartInterface.View
) : ShoppingCartInterface.Presenter {
    private val model: ShoppingCartInterface.Model = ShoppingCartModel(this)

    override fun hideIncludeShoppingCart() {
        view.hideIncludeShoppingCart()
    }

    override fun addAdapter() {
        view.addAdapter()
    }

    override fun showResult(result: Double) {
        view.showResult(result)
    }

    override fun calculateResult(shoppingCarts: List<ShoppingCart>) {
        model.calculateResult(shoppingCarts)
    }

    override fun showShoppingCarts(shoppingCarts: List<ShoppingCart>) {
        view.showShoppingCarts(shoppingCarts)
    }

    override fun consultShoppingCarts() {
        model.consultShoppingCarts()
    }
}