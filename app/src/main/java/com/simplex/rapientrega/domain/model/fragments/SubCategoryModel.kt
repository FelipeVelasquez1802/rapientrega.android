package com.simplex.rapientrega.domain.model.fragments

import com.simplex.rapientrega.data.api.entities.ProductKeyEntity
import com.simplex.rapientrega.data.api.repositories.RepositoryImpl
import com.simplex.rapientrega.domain.interfaces.SubCategoryInterface
import com.simplex.rapientrega.domain.tools.ERROR
import com.simplex.rapientrega.domain.tools.HIDE
import com.simplex.rapientrega.domain.tools.LIST_EMPTY
import com.simplex.rapientrega.domain.tools.SHOW
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubCategoryModel(private val presenter: SubCategoryInterface.Presenter) :
    SubCategoryInterface.Model,
    Callback<ProductKeyEntity> {

    private val repository: RepositoryImpl =
        RepositoryImpl()
    private var storeId: Int = -1

    override fun consultSubCategories(storeId: Int) {
        this.storeId = storeId
        presenter.stateProgressBar(SHOW)
        repository.service().products(storeId).enqueue(this)
    }

    override fun onFailure(call: Call<ProductKeyEntity>, t: Throwable) {
        presenter.showAlertMessage(ERROR)
        presenter.stateProgressBar(HIDE)
    }

    override fun onResponse(call: Call<ProductKeyEntity>, response: Response<ProductKeyEntity>) {
        presenter.stateProgressBar(HIDE)
        val productKey: ProductKeyEntity? = response.body()
        if (!response.isSuccessful || productKey == null || productKey.productCategories.isEmpty()) {
            presenter.showAlertMessage(LIST_EMPTY)
            presenter.showListEmpty()
            return
        }
        val productCategory = productKey.productCategories
        presenter.showSubCategories(productCategory)
    }
}