package com.simplex.rapientrega.presentation.presenters.fragments

import com.simplex.rapientrega.domain.interfaces.ProductInterface
import com.simplex.rapientrega.domain.model.fragments.ProductModel
import com.simplex.rapientrega.data.objects.Product

class ProductPresenter(private val view: ProductInterface.View) : ProductInterface.Presenter {
    private val model: ProductInterface.Model = ProductModel(this)
    override fun showProducts(products: List<Product>) {
        view.showProducts(products)
    }

    override fun consultProducts() {
        model.consultProducts()
    }
}