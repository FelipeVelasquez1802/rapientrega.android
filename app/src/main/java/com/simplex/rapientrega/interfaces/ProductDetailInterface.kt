package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.objects.Product

interface ProductDetailInterface {
    interface View {
        fun showProductDetail(product: Product)
    }

    interface Presenter {
        fun showProductDetail(product: Product)
        fun consultProductDetail()
    }

    interface Model {
        fun consultProductDetail()
    }
}