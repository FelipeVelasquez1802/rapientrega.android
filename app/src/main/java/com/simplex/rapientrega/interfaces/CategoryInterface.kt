package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.objects.Category

interface CategoryInterface {
    interface View {
        fun showCategories(categories: List<Category>)
    }

    interface Presenter {
        fun showCategories(categories: List<Category>)
        fun consultCategories()
    }

    interface Model {
        fun consultCategories()
    }
}