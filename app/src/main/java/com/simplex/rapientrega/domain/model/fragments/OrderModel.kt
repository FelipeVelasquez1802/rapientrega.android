package com.simplex.rapientrega.domain.model.fragments

import com.simplex.rapientrega.domain.interfaces.OrderInterface
import com.simplex.rapientrega.domain.tools.toListOrder

class OrderModel(private val presenter: OrderInterface.Presenter) : OrderInterface.Model {
    override fun consultOrderS(string: String?) {
        val orders = toListOrder(string)
        presenter.putOrders(orders)
    }
}