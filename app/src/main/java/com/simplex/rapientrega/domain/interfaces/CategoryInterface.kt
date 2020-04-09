package com.simplex.rapientrega.domain.interfaces

import android.content.SharedPreferences
import com.simplex.rapientrega.data.api.entities.StoreCategoryEntity
import com.simplex.rapientrega.data.api.entities.stores.UbicationEntity

interface CategoryInterface {
    interface View {
        fun initialElements()
        fun initialObjects()
        fun addListeners()
        fun havePermissions()
        fun showDialogLocation()
        fun hideDialogLocation()
        fun showCategories(categories: List<StoreCategoryEntity>?)
        fun showAlertError(id: Int)
        fun stateProgressBar(id: Int)
        fun showListEmpty()
        fun hideListEmpty()
        fun showDialogCity()
        fun getCity(city: String)
    }

    interface Presenter {
        fun initial()
        fun havePermissions()
        fun showDialogLocation()
        fun hideDialogLocation()
        fun showCategories(categories: List<StoreCategoryEntity>?)
        fun showAlertError(id: String)
        fun stateProgressBar(id: String)
        fun showListEmpty()
        fun hideListEmpty()
        fun consultCategories(city: String, latitude: Double, longitude: Double)
        fun verifyCity(preferences: SharedPreferences)
    }

    interface Model {
        fun consultCategories(city: String, ubicationEntity: UbicationEntity)
    }
}