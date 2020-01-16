package com.simplex.rapientrega.tests

import com.simplex.rapientrega.objects.Category

class CategoryTest {
    fun categoriesList(): List<Category> {
        var categories = ArrayList<Category>()
        categories.add(
            Category(
                "Restaurante",
                "https://gmediac.com/files/2017/11/mejores-paginas-web-para-restaurante.jpg",
                ProviderTest().providersList()
            )
        )
        categories.add(
            Category(
                "Drogueria",
                "http://www.centenariocc.com/wp-content/uploads/2019/06/gal-drogueria-comfandi-01.jpg",
                ProviderTest().providersList2()
            )
        )
        categories.add(
            Category(
                "Mapa",
                "https://www.muypymes.com/wp-content/uploads/2018/03/googlemaps-googledevelopers1-660x330.png",
                true
            )
        )
        return categories
    }
}