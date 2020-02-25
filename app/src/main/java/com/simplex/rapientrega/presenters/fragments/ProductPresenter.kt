package com.simplex.rapientrega.presenters.fragments

import com.simplex.rapientrega.interfaces.ProductInterface
import com.simplex.rapientrega.model.fragments.ProductModel
import com.simplex.rapientrega.objects.Product

class ProductPresenter(private val view: ProductInterface.View) : ProductInterface.Presenter {
    private val model: ProductInterface.Model = ProductModel(this)
    override fun showProducts(products: List<Product>) {
        view.showProducts(products)
    }

    override fun consultProducts() {
        model.consultProducts()
    }
}