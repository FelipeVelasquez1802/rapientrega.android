package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.StoreCategoryEntity
import com.simplex.rapientrega.data.api.entities.stores.UbicationEntity

interface CategoryInterface {
    interface View {
        fun initialElements()
        fun initialObjects()
        fun addListeners()
        fun showCategories(categories: List<StoreCategoryEntity>?)
        fun showAlertError(id: Int)
        fun stateProgressBar(id: Int)
        fun showListEmpty()
        fun hideListEmpty()
        fun showDialogCity()
        fun searchUbication()
    }

    interface Presenter {
        fun initial()
        fun showCategories(categories: List<StoreCategoryEntity>?)
        fun showAlertError(id: String)
        fun stateProgressBar(id: String)
        fun showListEmpty()
        fun hideListEmpty()
        fun consultCategories(city: String?, ubicationEntity: UbicationEntity?)
    }

    interface Model {
        fun consultCategories(city: String, ubicationEntity: UbicationEntity)
    }
}