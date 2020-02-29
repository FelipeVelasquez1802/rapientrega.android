package com.simplex.rapientrega.presenters.fragments

import com.simplex.rapientrega.api.entities.OrderEntity
import com.simplex.rapientrega.interfaces.OrderInterface
import com.simplex.rapientrega.model.fragments.OrderModel

class OrderPresenter(private val view: OrderInterface.View) : OrderInterface.Presenter {

    private val model: OrderInterface.Model = OrderModel(this)
    override fun consultOrders(string: String?) {
        model.consultOrderS(string)
    }

    override fun putOrders(orders: List<OrderEntity>) {
        view.putOrders(orders)
    }

}