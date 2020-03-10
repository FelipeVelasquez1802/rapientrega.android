package com.simplex.rapientrega.presentation.presenters.fragments

import com.simplex.rapientrega.data.api.entities.ProductEntity
import com.simplex.rapientrega.domain.interfaces.ProductDetailInterface
import com.simplex.rapientrega.domain.model.fragments.ProductDetailModel

class ProductDetailPresenter(private val view: ProductDetailInterface.View) :
    ProductDetailInterface.Presenter {

    private val model: ProductDetailInterface.Model = ProductDetailModel(this)

    override fun addSharedPreference(string: String) {
        view.addSharedPreference(string)
    }

    override fun addProductToCar(product: ProductEntity, count: String, list: String?) {
        model.addProductToCar(product, count.toInt(), list)
    }
}