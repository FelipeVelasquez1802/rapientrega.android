package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.ProductEntity

interface ProductDetailInterface {
    interface View {
        fun addShoppingCart(string: String)
        fun addListener()
        fun initialElements()
        fun subtract(count: String, flag: Boolean)
        fun add(count: String, flag: Boolean)
    }

    interface Presenter {
        fun addShoppingCart(string: String)
        fun addProductToCar(product: ProductEntity, count: String, list: String?)
        fun initial()
        fun left(count: String)
        fun right(count: String)
        fun subtract(count: Int)
        fun add(count: Int)
    }

    interface Model {
        fun addProductToCar(product: ProductEntity, count: Int, list: String?)
        fun left(count: Int)
        fun right(count: Int)
    }
}