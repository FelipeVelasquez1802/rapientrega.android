package com.simplex.rapientrega.domain.model.adapters

import com.simplex.rapientrega.data.api.entities.shoppingcart.ShoppingCartEntity
import com.simplex.rapientrega.domain.interfaces.ShoppingCartInterface

class ShoppingCartModel(private val presenter: ShoppingCartInterface.AdapterPresenter) :
    ShoppingCartInterface.AdapterModel {
    override fun left(count: Int, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>) {
        val countLess = count - 1
        val price = calculate(countLess, id, shoppingCarts)
        presenter.subtract(countLess)
        presenter.updateTotal(price)
    }

    override fun right(count: Int, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>) {
        val countPlus = count + 1
        val price = calculate(countPlus, id, shoppingCarts)
        presenter.add(countPlus)
        presenter.updateTotal(price)
    }

    override fun calculate(
        count: Int, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>
    ): Double {
        return shoppingCarts.map {
            it.product.price * if (it.id == id) count else it.count
        }.sum()
    }

    override fun deleteRow(shoppingCarts: ArrayList<ShoppingCartEntity>, row: Int) {
        shoppingCarts.removeAt(row)
    }
}