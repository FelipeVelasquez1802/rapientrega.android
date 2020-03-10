package com.simplex.rapientrega.presentation.presenters.activities

import com.simplex.rapientrega.domain.interfaces.MainInterface
import com.simplex.rapientrega.domain.model.activities.MainModel
import com.simplex.rapientrega.presentation.views.fragments.MainFragment

class MainPresenter(private val view: MainInterface.View) : MainInterface.Presenter {

    private val model = MainModel(this)
    override fun addFragment(id: Int, fragment: MainFragment) {
        view.addFragment(id, fragment)
    }

    override fun goShoppingCartActivity() {
        view.goShoppingCartActivity()
    }

}