package com.simplex.rapientrega.presenters.activities

import com.simplex.rapientrega.api.entities.ShoppingCartEntity
import com.simplex.rapientrega.interfaces.ShoppingCartInterface
import com.simplex.rapientrega.model.activities.ShoppingCartModel

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

    override fun calculateResult(shoppingCarts: List<ShoppingCartEntity>) {
        model.calculateResult(shoppingCarts)
    }

    override fun showShoppingCarts(products: List<ShoppingCartEntity>) {
        view.showShoppingCarts(products)
    }

    override fun consultShoppingCarts(string: String?) {
        model.consultShoppingCarts(string)
    }

    override fun convertProducts(products: List<ShoppingCartEntity>) {
        model.convertProducts(products)
    }

    override fun saveProducts(string: String?) {
        view.saveProducts(string)
        view.deleteProducts()
        view.goMainActivity()
    }
}