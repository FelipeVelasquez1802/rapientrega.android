package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.shoppingcart.ShoppingCartEntity

interface ShoppingCartInterface {
    interface View {
        fun addAdapter()
        fun showShoppingCarts(products: List<ShoppingCartEntity>)
        fun payProducts(string: String?)
        fun deleteProducts()
        fun goMainActivity()
        fun showMessage(id: Int)
        fun changeList(shoppingCarts: List<ShoppingCartEntity>)
        fun updateTotal(total: String)
        fun goShoppingCartDataActivity()
    }

    interface Presenter {
        fun addAdapter()
        fun showShoppingCarts(products: List<ShoppingCartEntity>)
        fun consultShoppingCarts(string: String?)
        fun convertProducts(products: List<ShoppingCartEntity>, list: String?)
        fun payProducts(string: String?)
        fun changeList(shoppingCarts: List<ShoppingCartEntity>)
        fun goShoppingCartData()
    }

    interface Model {
        fun consultShoppingCarts(string: String?)
        fun convertProducts(products: List<ShoppingCartEntity>, list: String?)
    }

    interface AdapterView {
        fun subtract(value: Int, flag: Boolean)
        fun add(value: Int, flag: Boolean)
        fun updateTotal(total: Double)
    }

    interface AdapterPresenter {
        fun left(count: String, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>)
        fun right(count: String, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>)
        fun subtract(value: Int)
        fun add(value: Int)
        fun updateTotal(total: Double)
        fun calculate(count: String, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>): Double
        fun deleteRow(shoppingCarts: ArrayList<ShoppingCartEntity>, row: Int)
    }

    interface AdapterModel {
        fun left(count: Int, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>)
        fun right(count: Int, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>)
        fun calculate(count: Int, id: Int, shoppingCarts: ArrayList<ShoppingCartEntity>): Double
        fun deleteRow(shoppingCarts: ArrayList<ShoppingCartEntity>, row: Int)
    }
}