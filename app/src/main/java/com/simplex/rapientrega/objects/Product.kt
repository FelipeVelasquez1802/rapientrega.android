package com.simplex.rapientrega.objects

class Product {
    var name: String
    lateinit var photo: String
    var photos: ArrayList<String>? = null
    var description: String
    var price: Double = 0.0

    constructor(name: String, photo: String, description: String, price: Double) {
        this.name = name
        this.photo = photo
        this.description = description
        this.price = price
    }

    constructor(name: String, photos: ArrayList<String>, description: String, price: Double) {
        this.name = name
        this.photos = photos
        this.description = description
        this.price = price
    }
}