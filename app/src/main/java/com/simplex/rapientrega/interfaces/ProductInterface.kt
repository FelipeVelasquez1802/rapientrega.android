package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.objects.Product

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