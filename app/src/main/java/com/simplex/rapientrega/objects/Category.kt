package com.simplex.rapientrega.objects

class Category {

    var name: String
    var photo: String
    lateinit var providers: List<Provider>
    var flag: Boolean = false

    constructor(name: String, photo: String) {
        this.name = name
        this.photo = photo
    }

    constructor(name: String, photo: String, providers: List<Provider>) {
        this.name = name
        this.photo = photo
        this.providers = providers
    }

    constructor(name: String, photo: String, flag: Boolean) {
        this.name = name
        this.photo = photo
        this.flag = flag
    }

}