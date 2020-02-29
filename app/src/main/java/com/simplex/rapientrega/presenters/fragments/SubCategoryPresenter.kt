package com.simplex.rapientrega.presenters.fragments

import com.simplex.rapientrega.R
import com.simplex.rapientrega.api.entities.ProductCategoriesEntity
import com.simplex.rapientrega.api.entities.ProductKeyEntity
import com.simplex.rapientrega.interfaces.SubCategoryInterface
import com.simplex.rapientrega.model.fragments.SubCategoryModel
import com.simplex.rapientrega.tools.LIST_EMPTY

class SubCategoryPresenter(private val view: SubCategoryInterface.View) :
    SubCategoryInterface.Presenter {

    private val model: SubCategoryInterface.Model = SubCategoryModel(this)
    override fun showSubCategories(subcategories: List<ProductCategoriesEntity>) {
        view.showSubCategories(subcategories)
    }

    override fun consultSubCategories(id: Int) {
        model.consultSubCategories(id)
    }

    override fun showAlertMessage(id: String) {
        view.showAlertMessage(
            when (id) {
                LIST_EMPTY -> R.string.list_empty
                else -> R.string.error
            }
        )
    }
}