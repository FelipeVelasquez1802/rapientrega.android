package com.simplex.rapientrega.presenters.fragments

import com.simplex.rapientrega.interfaces.MainFragmentInterface
import com.simplex.rapientrega.model.fragments.MainFragmentModel

class MainFragmentPresenter(private val view: MainFragmentInterface.View) :
    MainFragmentInterface.Presenter {
    private val model: MainFragmentInterface.Model = MainFragmentModel(this)
    override fun addAdapter() {
        view.addAdapter()
    }


}