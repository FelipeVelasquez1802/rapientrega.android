package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.api.entities.ProductEntity
import com.simplex.rapientrega.objects.Product

interface ProductDetailInterface {
    interface View {
        fun showProductDetail(product: ProductEntity)
    }

    interface Presenter {
        fun showProductDetail(product: ProductEntity)
    }

    interface Model {
    }
}