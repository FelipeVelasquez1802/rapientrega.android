package com.simplex.rapientrega.presentation.presenters.fragments

import android.view.View
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.ProductCategoriesEntity
import com.simplex.rapientrega.domain.interfaces.SubCategoryInterface
import com.simplex.rapientrega.domain.model.fragments.SubCategoryModel
import com.simplex.rapientrega.domain.tools.HIDE
import com.simplex.rapientrega.domain.tools.LIST_EMPTY
import com.simplex.rapientrega.domain.tools.SHOW

class SubCategoryPresenter(private val view: SubCategoryInterface.View) :
    SubCategoryInterface.Presenter {

    private val model: SubCategoryInterface.Model = SubCategoryModel(this)
    override fun initial() {
        view.initialElements()
        view.initialObjects()
    }

    override fun showSubCategories(subcategories: List<ProductCategoriesEntity>) {
        view.showSubCategories(subcategories)
    }

    override fun consultSubCategories(storeId: Int) {
        model.consultSubCategories(storeId)
    }

    override fun showAlertMessage(id: String) {
        view.showAlertMessage(
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