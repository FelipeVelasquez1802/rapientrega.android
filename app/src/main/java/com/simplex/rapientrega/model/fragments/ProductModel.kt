package com.simplex.rapientrega.model.fragments

import com.simplex.rapientrega.interfaces.ProductInterface
import com.simplex.rapientrega.tests.ProductTest

class ProductModel(private val presenter: ProductInterface.Presenter) : ProductInterface.Model {
    override fun consultProducts() {
        presenter.showProducts(ProductTest().productList())
    }
}