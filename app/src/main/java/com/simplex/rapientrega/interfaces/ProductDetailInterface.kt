package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.api.entities.ProductEntity

interface ProductDetailInterface {
    interface View {
        fun addSharedPreference(string: String)
    }

    interface Presenter {
        fun addSharedPreference(string: String)
        fun addProductToCar(product: ProductEntity, count: String, list: String?)
    }

    interface Model {
        fun addProductToCar(product: ProductEntity, count: Int, list: String?)
    }
}