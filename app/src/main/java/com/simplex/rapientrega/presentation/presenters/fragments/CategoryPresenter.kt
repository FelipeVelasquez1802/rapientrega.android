package com.simplex.rapientrega.presentation.presenters.fragments

import android.view.View
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.StoreCategoryEntity
import com.simplex.rapientrega.domain.interfaces.CategoryInterface
import com.simplex.rapientrega.domain.model.fragments.CategoryModel
import com.simplex.rapientrega.domain.tools.HIDE
import com.simplex.rapientrega.domain.tools.LIST_EMPTY
import com.simplex.rapientrega.domain.tools.SHOW

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

    override fun stateProgressBar(id: String) {
        when (id) {
            SHOW -> view.stateProgressBar(View.VISIBLE)
            HIDE -> view.stateProgressBar(View.GONE)
        }
    }

}