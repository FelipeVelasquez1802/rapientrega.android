package com.simplex.rapientrega.objects

class ShoppingCart {
    lateinit var photo: String
    lateinit var name: String
    var count: Int = 0

    constructor(photo: String, name: String, count: Int) {
        this.photo = photo
        this.name = name
        this.count = count
    }


    fun countFormat(): String {
        return "$count"
    }
}