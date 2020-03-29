package com.simplex.rapientrega.presentation.presenters.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.shoppingcart.ShoppingCartEntity
import com.simplex.rapientrega.domain.interfaces.ShoppingCartInterface
import com.simplex.rapientrega.domain.model.activities.ShoppingCartModel

class ShoppingCartPresenter(private val view: ShoppingCartInterface.View) :
    ShoppingCartInterface.Presenter {

    private val model: ShoppingCartInterface.Model = ShoppingCartModel(this)

    override fun addAdapter() {
        view.addAdapter()
    }

    override fun showShoppingCarts(products: List<ShoppingCartEntity>) {
        if (products.isNotEmpty()) view.showShoppingCarts(products)
        else {
            view.goMainActivity()
            view.showMessage(R.string.list_empty)
        }
    }

    override fun consultShoppingCarts(string: String?) {
        model.consultShoppingCarts(string)
    }

    override fun convertProducts(products: List<ShoppingCartEntity>, list: String?) {
        model.convertProducts(products, list)
    }

    override fun payProducts(string: String?) {
//        view.payProducts(string)
//        view.deleteProducts()
//        view.goMainActivity()
        view.goShoppingCartDataActivity()
    }

    override fun changeList(shoppingCarts: List<ShoppingCartEntity>) {
        view.changeList(shoppingCarts)
    }

    override fun goShoppingCartData() {
        view.goShoppingCartDataActivity()
    }
}