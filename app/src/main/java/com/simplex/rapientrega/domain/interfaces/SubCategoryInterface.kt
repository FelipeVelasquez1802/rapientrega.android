package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.ProductCategoriesEntity

interface SubCategoryInterface {
    interface View {
        fun initialObjects()
        fun initialElements()
        fun showSubCategories(subcategories: List<ProductCategoriesEntity>)
        fun showAlertMessage(id: Int)
        fun stateProgressBar(id: Int)
    }

    interface Presenter {
        fun initial()
        fun showSubCategories(subcategories: List<ProductCategoriesEntity>)
        fun consultSubCategories(storeId: Int)
        fun showAlertMessage(id: String)
        fun stateProgressBar(id: String)
    }

    interface Model {
        fun consultSubCategories(storeId: Int)
    }
}