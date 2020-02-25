package com.simplex.rapientrega.model.fragments

import com.simplex.rapientrega.interfaces.SubCategoryInterface
import com.simplex.rapientrega.tests.SubCategoryTest

class SubCategoryModel(private val presenter: SubCategoryInterface.Presenter) :
    SubCategoryInterface.Model {
    override fun consultSubCategories() {
        presenter.showSubCategories(SubCategoryTest().subCategoriesList())
    }
}