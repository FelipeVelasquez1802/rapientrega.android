package com.simplex.rapientrega.model.fragments

import com.simplex.rapientrega.interfaces.CategoryInterface
import com.simplex.rapientrega.tests.CategoryTest

class CategoryModel(private val presenter: CategoryInterface.Presenter) : CategoryInterface.Model {
    override fun consultCategories() {
        presenter.showCategories(CategoryTest().categoriesList())
    }
}