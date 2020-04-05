package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.ProfileEntity
import com.simplex.rapientrega.data.api.entities.orders.OrderEntity

interface OrderInterface {
    interface View {
        fun initialElements()
        fun initialObjects()
        fun showOrders(orders: List<OrderEntity>)
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
        fun getUser(profile: ProfileEntity)
    }

    interface Presenter {
        fun initial()
        fun consultOrders(userId: Int)
        fun showOrders(orders: List<OrderEntity>)
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
        fun convertUser(string: String?)
        fun getUser(profile: ProfileEntity)
    }

    interface Model {
        fun consultOrders(userId: Int)
        fun convertUser(string: String)
//        fun consultOrderS(string: String?)
    }
}