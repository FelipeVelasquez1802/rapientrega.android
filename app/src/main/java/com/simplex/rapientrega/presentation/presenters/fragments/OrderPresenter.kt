package com.simplex.rapientrega.presentation.presenters.fragments

import com.simplex.rapientrega.data.api.entities.ProfileEntity
import com.simplex.rapientrega.data.api.entities.orders.OrderEntity
import com.simplex.rapientrega.domain.interfaces.OrderInterface
import com.simplex.rapientrega.domain.model.fragments.OrderModel
import com.simplex.rapientrega.domain.tools.ERROR

class OrderPresenter(private val view: OrderInterface.View) : OrderInterface.Presenter {

    private val model: OrderInterface.Model = OrderModel(this)
    override fun initial() {
        view.initialElements()
        view.initialObjects()
    }

    override fun consultOrders(userId: Int) {
        model.consultOrders(userId)
    }

    override fun showOrders(orders: List<OrderEntity>) {
        view.showOrders(orders)
    }

    override fun showLoading() {
        view.showLoading()
    }

    override fun hideLoading() {
        view.hideLoading()
    }

    override fun showError(message: String) {
        view.showError(message)
    }

    override fun convertUser(string: String?) {
        if (string == null) view.showError(ERROR)
        else model.convertUser(string)
    }

    override fun getUser(profile: ProfileEntity) {
        view.getUser(profile)
    }

//    override fun consultOrders(string: String?) {
//        model.consultOrderS(string)
//    }
//
//    override fun putOrders(orders: List<OrderEntity>) {
//        view.putOrders(orders)
//    }

}