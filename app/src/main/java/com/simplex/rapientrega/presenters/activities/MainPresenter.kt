package com.simplex.rapientrega.presenters.activities

import com.simplex.rapientrega.interfaces.MainInterface
import com.simplex.rapientrega.model.activities.MainModel
import com.simplex.rapientrega.views.fragments.MainFragment

class MainPresenter(private val view: MainInterface.View) : MainInterface.Presenter {

    private val model = MainModel(this)
    override fun addFragment(id: Int, fragment: MainFragment) {
        view.addFragment(id, fragment)
    }

    override fun goShoppingCartActivity() {
        view.goShoppingCartActivity()
    }

}