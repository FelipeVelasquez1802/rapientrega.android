package com.simplex.rapientrega.presentation.presenters.adapters

import com.simplex.rapientrega.data.api.entities.ShoppingCartEntity
import com.simplex.rapientrega.domain.interfaces.ShoppingCartInterface
import com.simplex.rapientrega.domain.model.adapters.ShoppingCartModel

class ShoppingCartPresenter(private val view: ShoppingCartInterface.AdapterView) :
    ShoppingCartInterface.AdapterPresenter {

    private var model: ShoppingCartInterface.AdapterModel = ShoppingCartModel(this)

    override fun left(count: String, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>) {
        model.left(count.toInt(), id, shoppingCarts)
    }

    override fun right(count: String, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>) {
        model.right(count.toInt(), id, shoppingCarts)
    }

    override fun subtract(value: Int) {
        var flag = true
        if (value == 1) {
            flag = false
        }
        view.subtract(value, flag)
    }

    override fun add(value: Int) {
        view.subtract(value, true)
    }

    override fun updateTotal(total: Double) {
        view.updateTotal(total)
    }

    override fun calculate(
        count: String, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>
    ): Double {
        return model.calculate(count.toInt(), id, shoppingCarts)
    }

    override fun deleteRow(shoppingCarts: ArrayList<ShoppingCartEntity>, row: Int) {
        model.deleteRow(shoppingCarts, row)
    }

}