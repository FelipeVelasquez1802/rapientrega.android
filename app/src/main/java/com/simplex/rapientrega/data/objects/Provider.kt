package com.simplex.rapientrega.data.objects

class Provider {
    var id: Int = 0
    var photo: String = ""
    var name: String = ""
    var category: String = ""
    var isOpen: Boolean = false
    var shippingCost: Double = 0.0
    var minimumOrder: Double = 0.0

    constructor(
        id: Int,
        photo: String,
        name: String,
        category: String,
        isOpen: Boolean,
        shippingCost: Double,
        minimumOrder: Double
    ) {
        this.id = id
        this.photo = photo
        this.name = name
        this.category = category
        this.isOpen = isOpen
        this.shippingCost = shippingCost
        this.minimumOrder = minimumOrder
    }
}