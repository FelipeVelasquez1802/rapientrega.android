package com.simplex.rapientrega.tests

import com.simplex.rapientrega.objects.SubCategory

class SubCategoryTest {

    fun subCategoriesList(): List<SubCategory> {
        var subCategories = ArrayList<SubCategory>()
        subCategories.add(
            SubCategory(
                "Hamburguesa",
                "https://cocina-casera.com/wp-content/uploads/2016/11/hamburguesa-queso-receta.jpg"
            )
        )
        subCategories.add(
            SubCategory(
                "Bebidas",
                "https://www.diariodemorelos.com/noticias/sites/default/files/field/image/bebidas-151119.jpg"
            )
        )
        return subCategories
    }
}