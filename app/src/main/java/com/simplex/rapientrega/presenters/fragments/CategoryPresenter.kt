package com.simplex.rapientrega.presenters.fragments

import com.simplex.rapientrega.R
import com.simplex.rapientrega.api.entities.StoreCategoryEntity
import com.simplex.rapientrega.interfaces.CategoryInterface
import com.simplex.rapientrega.model.fragments.CategoryModel
import com.simplex.rapientrega.tools.LIST_EMPTY

class CategoryPresenter(private val view: CategoryInterface.View) : CategoryInterface.Presenter {

    private val model: CategoryInterface.Model = CategoryModel(this)
    override fun showCategories(categories: List<StoreCategoryEntity>) {
        view.showCategories(categories)
    }


    override fun consultCategories() {
        model.consultCategories()
    }

    override fun showAlertError(id: String) {
        view.showAlertError(
            when (id) {
                LIST_EMPTY -> R.string.list_empty
                else -> R.string.error
            }
        )
    }

}