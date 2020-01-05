package com.simplex.rapientrega.tests

import com.simplex.rapientrega.objects.Product

class ProductTest {

    fun productList(): List<Product> {
        var products = ArrayList<Product>()
        products.add(
            Product(
                "Galleta",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStIwbeHLccB8TaHHRLNanthpA38dm84Q5ODlZ0eJ-umGAOs7mA&s",
                "Descripcion",
                600.0

            )
        )
        products.add(
            Product(
                "Cerveza",
                "https://jumbocolombiafood.vteximg.com.br/arquivos/ids/218131-750-750/7707358310753-1.jpg?v=636296101339630000",
                "Descripcion",
                20000.0

            )
        )
        return products
    }

    fun product(): Product {
        var photos = ArrayList<String>()
        photos.add("https://jumbocolombiafood.vteximg.com.br/arquivos/ids/218131-750-750/7707358310753-1.jpg?v=636296101339630000")
        photos.add("https://exitocol.vteximg.com.br/arquivos/ids/1048270/Cerveza-Cajica-Miel-Paq-X-4-Und-330ml-C-u-924591_a.jpg?v=637130618119570000")
        photos.add("https://static.iris.net.co/dinero/upload/images/2019/8/26/276028_1.jpg")
        return Product(
            "Cerveza",
            photos,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            20000.0
        )
    }
}