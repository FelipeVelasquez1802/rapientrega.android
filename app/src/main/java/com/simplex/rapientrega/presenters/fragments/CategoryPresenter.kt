package com.simplex.rapientrega.presenters.fragments

import com.simplex.rapientrega.interfaces.CategoryInterface
import com.simplex.rapientrega.model.fragments.CategoryModel
import com.simplex.rapientrega.objects.Category

class CategoryPresenter(private val view: CategoryInterface.View) : CategoryInterface.Presenter {

    private val model: CategoryInterface.Model = CategoryModel(this)
    override fun showCategories(categories: List<Category>) {
        view.showCategories(categories)
    }

    override fun consultCategories() {
        model.consultCategories()
    }

}