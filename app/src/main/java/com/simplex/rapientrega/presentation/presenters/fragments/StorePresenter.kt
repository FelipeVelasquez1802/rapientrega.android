package com.simplex.rapientrega.presentation.presenters.fragments

import com.simplex.rapientrega.domain.interfaces.StoreInterface
import com.simplex.rapientrega.domain.model.fragments.StoreModel

class StorePresenter(private val view: StoreInterface.View) : StoreInterface.Presenter {
    private val model: StoreInterface.Model = StoreModel(this)

    override fun consultProviders() {
        model.consultProviders()
    }
}