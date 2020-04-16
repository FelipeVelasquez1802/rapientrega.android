package com.simplex.rapientrega.presentation.presenters.fragments

import android.view.View
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.StoreCategoryEntity
import com.simplex.rapientrega.data.api.entities.stores.UbicationEntity
import com.simplex.rapientrega.domain.interfaces.CategoryInterface
import com.simplex.rapientrega.domain.model.fragments.CategoryModel
import com.simplex.rapientrega.domain.tools.HIDE
import com.simplex.rapientrega.domain.tools.LIST_EMPTY
import com.simplex.rapientrega.domain.tools.SHOW

class CategoryPresenter(private val view: CategoryInterface.View) : CategoryInterface.Presenter {

    private val model: CategoryInterface.Model = CategoryModel(this)

    override fun initial() {
        view.initialElements()
        view.initialObjects()
        view.addListeners()
        view.searchUbication()
    }

    override fun showCategories(categories: List<StoreCategoryEntity>?) {
        view.hideListEmpty()
        view.showCategories(categories)
    }

    override fun showAlertError(id: String) {
        view.showAlertError(
            when (id) {
                LIST_EMPTY -> R.string.list_empty
                else -> R.string.error
            }
        )
    }

    override fun stateProgressBar(id: String) {
        when (id) {
            SHOW -> view.stateProgressBar(View.VISIBLE)
            HIDE -> view.stateProgressBar(View.GONE)
        }
    }

    override fun showListEmpty() {
        view.showListEmpty()
    }

    override fun hideListEmpty() {
        view.hideListEmpty()
    }

    override fun consultCategories(city: String?, ubicationEntity: UbicationEntity?) {
        if (city == null || ubicationEntity == null) view.showListEmpty()
        else model.consultCategories(city, ubicationEntity)
    }

}