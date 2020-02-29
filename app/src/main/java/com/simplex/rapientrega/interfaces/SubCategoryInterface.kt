package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.api.entities.ProductCategoriesEntity

interface SubCategoryInterface {
    interface View {
        fun showSubCategories(subcategories: List<ProductCategoriesEntity>)
        fun showAlertMessage(id: Int)
        fun stateProgressBar(id: Int)
    }

    interface Presenter {
        fun showSubCategories(subcategories: List<ProductCategoriesEntity>)
        fun consultSubCategories(storeId: Int)
        fun showAlertMessage(id: String)
        fun stateProgressBar(id: String)
    }

    interface Model {
        fun consultSubCategories(storeId: Int)
    }
}