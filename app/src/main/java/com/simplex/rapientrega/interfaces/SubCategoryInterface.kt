package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.objects.SubCategory

interface SubCategoryInterface {
    interface View {
        fun showSubCategories(subcategories: List<SubCategory>)
    }

    interface Presenter {
        fun showSubCategories(subcategories: List<SubCategory>)
        fun consultSubCategories()
    }

    interface Model {
        fun consultSubCategories()
    }
}