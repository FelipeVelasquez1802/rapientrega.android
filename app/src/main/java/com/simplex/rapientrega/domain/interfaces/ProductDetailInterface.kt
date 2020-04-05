package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.ProductEntity

interface ProductDetailInterface {
    interface View {
        fun initialElements()
        fun initialObjects()
        fun loadProduct()
        fun addShoppingCart(string: String)
        fun addListener()
        fun subtract(count: String, flag: Boolean)
        fun add(count: String, flag: Boolean)
        fun updateCountShoppingCart(value: String)
    }

    interface Presenter {
        fun initial()
        fun addShoppingCart(string: String)
        fun addProductToCar(product: ProductEntity, count: String, list: String?)
        fun left(count: String)
        fun right(count: String)
        fun subtract(count: Int)
        fun add(count: Int)
        fun updateCountShoppingCart(count: Int)
    }

    interface Model {
        fun addProductToCar(product: ProductEntity, count: Int, list: String?)
        fun left(count: Int)
        fun right(count: Int)
    }
}