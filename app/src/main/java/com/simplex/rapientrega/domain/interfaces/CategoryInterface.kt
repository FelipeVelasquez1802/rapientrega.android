package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.StoreCategoryEntity

interface CategoryInterface {
    interface View {
        fun showCategories(categories: List<StoreCategoryEntity>?)
        fun showAlertError(id: Int)
        fun stateProgressBar(id: Int)
    }

    interface Presenter {
        fun showCategories(categories: List<StoreCategoryEntity>?)
        fun consultCategories()
        fun showAlertError(id: String)
        fun stateProgressBar(id: String)
    }

    interface Model {
        fun consultCategories()
    }
}