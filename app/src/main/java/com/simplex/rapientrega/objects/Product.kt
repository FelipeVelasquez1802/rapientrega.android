package com.simplex.rapientrega.objects

class Product {
    lateinit var name: String
    lateinit var photo: String
    lateinit var description: String
    var price: Double = 0.0

    constructor(name: String, photo: String, description: String, price: Double) {
        this.name = name
        this.photo = photo
        this.description = description
        this.price = price
    }
}