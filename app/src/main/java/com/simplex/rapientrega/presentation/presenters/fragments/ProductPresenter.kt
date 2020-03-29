package com.simplex.rapientrega.presentation.presenters.fragments

import com.simplex.rapientrega.domain.interfaces.ProductInterface
import com.simplex.rapientrega.domain.model.fragments.ProductModel

class ProductPresenter(private val view: ProductInterface.View) : ProductInterface.Presenter {

    private val model: ProductInterface.Model = ProductModel(this)
    override fun initial() {
        view.initialObjects()
        view.initialElements()
        view.showListEmpty()
    }

}