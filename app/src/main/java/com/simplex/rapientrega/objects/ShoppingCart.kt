package com.simplex.rapientrega.objects

class ShoppingCart {
    var product: Product
    var count: Int = 0

    constructor(product: Product, count: Int) {
        this.product = product
        this.count = count
    }


    fun countFormat(): String {
        return "$count"
    }
}