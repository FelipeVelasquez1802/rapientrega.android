package com.simplex.rapientrega.presentation.presenters.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.LoginEntity
import com.simplex.rapientrega.data.api.entities.shoppingcart.OrderUbicationEntity
import com.simplex.rapientrega.data.api.entities.shoppingcart.ShoppingCartEntity
import com.simplex.rapientrega.domain.interfaces.ShoppingCartDataInterface
import com.simplex.rapientrega.domain.model.activities.ShoppingCartDataModel
import com.simplex.rapientrega.domain.tools.LIST_EMPTY

class ShoppingCartDataPresenter(private val view: ShoppingCartDataInterface.View) :
    ShoppingCartDataInterface.Presenter {

    private val model: ShoppingCartDataInterface.Model = ShoppingCartDataModel(this)

    override fun initial() {
        view.initialElements()
        view.initialObjects()
    }

    override fun buildPay(
        city: String,
        address: String,
        shoppingCarts: ArrayList<ShoppingCartEntity>,
        userId: Int,
        latitude: Double,
        longitude: Double,
        paymentMethod: String
    ) {
        val orderUbication = OrderUbicationEntity(latitude, longitude)
        model.buildPay(city, address, shoppingCarts, userId, orderUbication, paymentMethod)
    }

    override fun getLoginEntity(loginEntity: LoginEntity) {
        view.getLoginEntity(loginEntity)
    }

    override fun convertUser(string: String?) {
        model.convertUser(string)
    }

    override fun pay() {
        view.pay()
        view.goMainActivity()
    }

    override fun showProgressBar() {
        view.showProgressBar()
    }

    override fun hideProgressBar() {
        view.hideProgressBar()
    }

    override fun showMessage(id: String) {
        view.showMessage(
            when (id) {
                LIST_EMPTY -> R.string.list_empty
                else -> R.string.error
            }
        )
    }
}