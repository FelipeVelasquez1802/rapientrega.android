package com.simplex.rapientrega.domain.model.fragments

import com.simplex.rapientrega.data.api.entities.orders.GeneralOrderEntity
import com.simplex.rapientrega.data.api.repositories.RepositoryImpl
import com.simplex.rapientrega.domain.interfaces.OrderInterface
import com.simplex.rapientrega.domain.tools.ERROR
import com.simplex.rapientrega.domain.tools.toLoginEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderModel(private val presenter: OrderInterface.Presenter) :
    OrderInterface.Model,
    Callback<GeneralOrderEntity> {

    private val repository: RepositoryImpl = RepositoryImpl()

    override fun consultOrders(userId: Int) {
        presenter.showLoading()
        repository.service().orders(userId).enqueue(this)
    }

    override fun convertUser(string: String) {
        val login = toLoginEntity(string)
        presenter.getUser(login.profile)
    }

    override fun onFailure(call: Call<GeneralOrderEntity>, t: Throwable) {
        presenter.hideLoading()
        presenter.showError("Error: ${t.message}")
    }

    override fun onResponse(
        call: Call<GeneralOrderEntity>, response: Response<GeneralOrderEntity>
    ) {
        presenter.hideLoading()
        if (!response.isSuccessful) {
            presenter.showError(ERROR)
            return
        }
        val generalOrder: GeneralOrderEntity? = response.body()
        if (generalOrder == null) {
            presenter.showError(ERROR)
            return
        }
        val orders = generalOrder.orders
        if (orders.isEmpty()) {
            presenter.showListEmpty()
            return
        }
        presenter.showOrders(orders)
    }

}