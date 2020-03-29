package com.simplex.rapientrega.domain.model.activities

import com.simplex.rapientrega.data.api.entities.shoppingcart.*
import com.simplex.rapientrega.data.api.repositories.RepositoryImpl
import com.simplex.rapientrega.domain.interfaces.ShoppingCartDataInterface
import com.simplex.rapientrega.domain.tools.ERROR
import com.simplex.rapientrega.domain.tools.toLoginEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShoppingCartDataModel(private val presenter: ShoppingCartDataInterface.Presenter) :
    ShoppingCartDataInterface.Model,
    Callback<PayResponseEntity> {

    private val repository: RepositoryImpl = RepositoryImpl()

    override fun buildPay(
        city: String,
        address: String,
        shoppingCarts: ArrayList<ShoppingCartEntity>,
        userId: Int,
        orderUbication: OrderUbicationEntity,
        paymentMethod: String
    ) {
        presenter.showProgressBar()
        val stores = convertShoppingCartListToStoresList(shoppingCarts)
        val payEntity = PayEntity(city, address, stores, userId, orderUbication, paymentMethod)
        repository.service().payProducts(payEntity).enqueue(this)
    }

    override fun convertUser(string: String?) {
        if (string != null) {
            val loginEntity = toLoginEntity(string)
            presenter.getLoginEntity(loginEntity)
        }
    }


    private fun convertShoppingCartListToStoresList(
        shoppingCarts: ArrayList<ShoppingCartEntity>
    ): ArrayList<StoresEntity> {
        val ids = getIds(shoppingCarts)
        return getStores(ids, shoppingCarts)
    }

    private fun getIds(shoppingCarts: ArrayList<ShoppingCartEntity>): List<Int> {
        val ids = ArrayList<Int>()
        shoppingCarts.forEach {
            ids.add(it.product.productCategoryId)
        }
        return ids.distinct()
    }

    private fun getStores(
        ids: List<Int>, shoppingCarts: ArrayList<ShoppingCartEntity>
    ): ArrayList<StoresEntity> {
        val stores = ArrayList<StoresEntity>()
        ids.forEach {
            val shoppingCartsFilter =
                shoppingCarts.filter { sc -> sc.product.productCategoryId == it }
            val products = ArrayList<ProductPayEntity>()
            shoppingCartsFilter.forEach { sc ->
                products.add(
                    ProductPayEntity(
                        sc.product.id,
                        sc.count
                    )
                )
            }
            stores.add(StoresEntity(it, products))
        }
        return stores
    }

    override fun onFailure(call: Call<PayResponseEntity>, t: Throwable) {
        presenter.hideProgressBar()
        presenter.showMessage(ERROR)
    }

    override fun onResponse(call: Call<PayResponseEntity>, response: Response<PayResponseEntity>) {
        presenter.hideProgressBar()
        if (!response.isSuccessful) {
            presenter.showMessage(ERROR)
            return
        }
        val payResponseEntity: PayResponseEntity? = response.body()
        if (payResponseEntity == null) {
            presenter.showMessage(ERROR)
            return
        }
        if (payResponseEntity.error) {
            presenter.showMessage(ERROR)
            return
        }
        if (payResponseEntity.created) {
            presenter.pay()
        }
    }
}