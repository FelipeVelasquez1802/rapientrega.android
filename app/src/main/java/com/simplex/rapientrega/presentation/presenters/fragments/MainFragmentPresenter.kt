package com.simplex.rapientrega.presentation.presenters.fragments

import com.simplex.rapientrega.domain.interfaces.MainFragmentInterface
import com.simplex.rapientrega.domain.model.fragments.MainFragmentModel

class MainFragmentPresenter(private val view: MainFragmentInterface.View) :
    MainFragmentInterface.Presenter {
    private val model: MainFragmentInterface.Model = MainFragmentModel(this)
    override fun addAdapter() {
        view.addAdapter()
    }


}