package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.OrderEntity

interface OrderInterface {
    interface View {
        fun putOrders(orders: List<OrderEntity>)
    }

    interface Presenter {
        fun consultOrders(string: String?)
        fun putOrders(orders: List<OrderEntity>)
    }

    interface Model {
        fun consultOrderS(string: String?)
    }
}