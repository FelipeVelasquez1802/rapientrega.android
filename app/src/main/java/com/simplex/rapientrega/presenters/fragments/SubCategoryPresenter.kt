package com.simplex.rapientrega.presenters.fragments

import com.simplex.rapientrega.interfaces.SubCategoryInterface
import com.simplex.rapientrega.model.fragments.SubCategoryModel
import com.simplex.rapientrega.objects.SubCategory

class SubCategoryPresenter(private val view: SubCategoryInterface.View) :
    SubCategoryInterface.Presenter {

    private val model: SubCategoryInterface.Model = SubCategoryModel(this)
    override fun showSubCategories(subcategories: List<SubCategory>) {
        view.showSubCategories(subcategories)
    }

    override fun consultSubCategories() {
        model.consultSubCategories()
    }
}