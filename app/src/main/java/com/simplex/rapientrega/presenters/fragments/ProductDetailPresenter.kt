package com.simplex.rapientrega.presenters.fragments

import com.simplex.rapientrega.api.entities.ProductEntity
import com.simplex.rapientrega.interfaces.ProductDetailInterface
import com.simplex.rapientrega.model.fragments.ProductDetailModel
import com.simplex.rapientrega.objects.Product

class ProductDetailPresenter(private val view: ProductDetailInterface.View) :
    ProductDetailInterface.Presenter {

    private val model: ProductDetailInterface.Model = ProductDetailModel(this)
    override fun showProductDetail(product: ProductEntity) {
        view.showProductDetail(product)
    }
}