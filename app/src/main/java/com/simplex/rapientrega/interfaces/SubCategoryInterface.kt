package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.api.entities.ProductCategoriesEntity

interface SubCategoryInterface {
    interface View {
        fun showSubCategories(subcategories: List<ProductCategoriesEntity>)
        fun showAlertMessage(id: Int)
    }

    interface Presenter {
        fun showSubCategories(subcategories: List<ProductCategoriesEntity>)
        fun consultSubCategories(id: Int)
        fun showAlertMessage(id: String)
    }

    interface Model {
        fun consultSubCategories(id: Int)
    }
}