package com.simplex.rapientrega.tests

import com.simplex.rapientrega.objects.ShoppingCart

class ShoppingCartTest {
    fun shoppingCartList(): List<ShoppingCart> {
        var shoppingCarts = ArrayList<ShoppingCart>()
        shoppingCarts.add(
            ShoppingCart(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStIwbeHLccB8TaHHRLNanthpA38dm84Q5ODlZ0eJ-umGAOs7mA&s",
                "Galleta",
                2
            )
        )
        shoppingCarts.add(
            ShoppingCart(
                "https://jumbocolombiafood.vteximg.com.br/arquivos/ids/218131-750-750/7707358310753-1.jpg?v=636296101339630000",
                "Cerveza",
                20
            )
        )
        return shoppingCarts
    }
}