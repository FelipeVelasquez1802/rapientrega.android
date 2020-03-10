package com.simplex.rapientrega.domain.model.fragments

import com.simplex.rapientrega.domain.interfaces.ProductInterface
import com.simplex.rapientrega.tests.ProductTest

class ProductModel(private val presenter: ProductInterface.Presenter) : ProductInterface.Model {
    override fun consultProducts() {
        presenter.showProducts(ProductTest().productList())
    }
}