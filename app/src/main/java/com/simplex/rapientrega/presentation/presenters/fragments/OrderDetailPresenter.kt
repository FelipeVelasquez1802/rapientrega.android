package com.simplex.rapientrega.presentation.presenters.fragments

import com.simplex.rapientrega.domain.interfaces.OrderDetailInterface

class OrderDetailPresenter(private val view: OrderDetailInterface.View) :
    OrderDetailInterface.Presenter {
    override fun initial() {
        view.initialObjects()
        view.initialElements()
    }
}