package com.simplex.rapientrega.data.objects

class User {
    var id: Int = 0
    var username: String = ""
    var email: String = ""
    var photo: String = ""

    constructor(id: Int, username: String, email: String, photo: String) {
        this.id = id
        this.username = username
        this.email = email
        this.photo = photo
    }
}