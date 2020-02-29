package com.simplex.rapientrega.model.activities

import android.util.Log
import com.simplex.rapientrega.api.entities.OrderEntity
import com.simplex.rapientrega.api.entities.ShoppingCartEntity
import com.simplex.rapientrega.interfaces.ShoppingCartInterface
import com.simplex.rapientrega.tools.objectToString
import com.simplex.rapientrega.tools.toListOrder
import com.simplex.rapientrega.tools.toListShoppingCart
import java.util.*

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

    override fun convertProducts(products: List<ShoppingCartEntity>, list: String?) {
        val order = OrderEntity()
        order.products = products
        order.date = Date()
        val listOrders = toListOrder(list)
        val string = objectToString(listOrders.plus(order))
        presenter.saveProducts(string)
    }

}