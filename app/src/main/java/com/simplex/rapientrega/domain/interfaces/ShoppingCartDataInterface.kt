package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.LoginEntity
import com.simplex.rapientrega.data.api.entities.shoppingcart.OrderUbicationEntity
import com.simplex.rapientrega.data.api.entities.shoppingcart.ShoppingCartEntity

interface ShoppingCartDataInterface {
    interface View {
        fun initialElements()
        fun initialObjects()
        fun getLoginEntity(loginEntity: LoginEntity)
        fun goMainActivity()
        fun pay()
        fun showProgressBar()
        fun hideProgressBar()
        fun showMessage(id: Int)
    }

    interface Presenter {
        fun initial()
        fun buildPay(
            city: String,
            address: String,
            shoppingCarts: ArrayList<ShoppingCartEntity>,
            userId: Int,
            latitude: Double,
            longitude: Double,
            paymentMethod: String
        )

        fun getLoginEntity(loginEntity: LoginEntity)
        fun convertUser(string: String?)
        fun pay()
        fun showProgressBar()
        fun hideProgressBar()
        fun showMessage(id: String)
    }

    interface Model {
        fun buildPay(
            city: String,
            address: String,
            shoppingCarts: ArrayList<ShoppingCartEntity>,
            userId: Int,
            orderUbication: OrderUbicationEntity,
            paymentMethod: String
        )

        fun convertUser(string: String?)
    }
}