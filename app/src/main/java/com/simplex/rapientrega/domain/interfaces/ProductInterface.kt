package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.objects.Product

interface ProductInterface {
    interface View {
        fun showProducts(products: List<Product>)
    }

    interface Presenter {
        fun showProducts(products: List<Product>)
        fun consultProducts()
    }

    interface Model {
        fun consultProducts()
    }
}