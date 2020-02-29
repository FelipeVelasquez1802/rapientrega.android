package com.simplex.rapientrega.model.fragments

import android.util.Log
import com.simplex.rapientrega.interfaces.OrderInterface
import com.simplex.rapientrega.tools.toListOrder

class OrderModel(private val presenter: OrderInterface.Presenter) : OrderInterface.Model {
    override fun consultOrderS(string: String?) {
        val orders = toListOrder(string)
        presenter.putOrders(orders)
    }
}