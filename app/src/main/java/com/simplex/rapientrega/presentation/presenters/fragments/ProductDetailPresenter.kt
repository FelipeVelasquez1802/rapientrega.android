package com.simplex.rapientrega.presentation.presenters.fragments

import com.simplex.rapientrega.data.api.entities.ProductEntity
import com.simplex.rapientrega.domain.interfaces.ProductDetailInterface
import com.simplex.rapientrega.domain.model.fragments.ProductDetailModel

class ProductDetailPresenter(private val view: ProductDetailInterface.View) :
    ProductDetailInterface.Presenter {

    private val model: ProductDetailInterface.Model = ProductDetailModel(this)

    override fun addShoppingCart(string: String) {
        view.addShoppingCart(string)
    }

    override fun addProductToCar(product: ProductEntity, count: String, list: String?) {
        model.addProductToCar(product, count.toInt(), list)
    }

    override fun initial() {
        view.initialObjects()
        view.initialElements()
        view.loadProduct()
        view.addListener()
    }

    override fun left(count: String) {
        model.left(count.toInt())
    }

    override fun right(count: String) {
        model.right(count.toInt())
    }

    override fun subtract(count: Int) {
        var flag = true
        if (count == 1) {
            flag = false
        }
        view.subtract("$count", flag)
    }

    override fun add(count: Int) {
        view.add("$count", true)
    }

    override fun updateCountShoppingCart(count: Int) {
        view.updateCountShoppingCart("$count")
    }
}