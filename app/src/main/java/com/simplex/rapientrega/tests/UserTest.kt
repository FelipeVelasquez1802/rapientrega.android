package com.simplex.rapientrega.tests

import com.simplex.rapientrega.objects.User

class UserTest {

    fun user(): User {
        return User(
            1,
            "Felipe Velásquez",
            "felipe.diaz95@hotmail.com",
            "https://media.licdn.com/dms/image/C5603AQGcsRZnIi-xPA/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=1gGuF4Kd4jYQBD7pWoYFL-FZ5zxJmx3iaIKxKe_2F3I"
        )
    }
}