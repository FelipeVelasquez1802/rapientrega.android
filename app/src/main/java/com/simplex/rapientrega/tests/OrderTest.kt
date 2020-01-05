package com.simplex.rapientrega.tests

import com.simplex.rapientrega.objects.Order

class OrderTest {
    fun ordersList(): List<Order> {
        var orders = ArrayList<Order>()
        orders.add(
            Order(
                "fecha 1",
                20000.0
            )
        )
        orders.add(
            Order(
                "fecha 2",
                30000.0
            )
        )
        return orders
    }
}