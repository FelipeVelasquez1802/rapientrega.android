package com.simplex.rapientrega.domain.model.fragments

import android.util.Log
import com.simplex.rapientrega.data.api.entities.CategoryEntity
import com.simplex.rapientrega.data.api.entities.stores.StoreBodyEntity
import com.simplex.rapientrega.data.api.entities.stores.UbicationEntity
import com.simplex.rapientrega.data.api.repositories.RepositoryImpl
import com.simplex.rapientrega.domain.interfaces.CategoryInterface
import com.simplex.rapientrega.domain.tools.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryModel(private val presenter: CategoryInterface.Presenter) :
    CategoryInterface.Model,
    Callback<CategoryEntity> {

    private val repository: RepositoryImpl = RepositoryImpl()

    override fun consultCategories(city: String, ubicationEntity: UbicationEntity) {
        presenter.stateProgressBar(SHOW)
        val bodyEntity = StoreBodyEntity(city, ubicationEntity)
        repository.service().storesPost(bodyEntity).enqueue(this)
    }

    override fun onFailure(call: Call<CategoryEntity>, t: Throwable) {
        presenter.showAlertError(ERROR)
        presenter.stateProgressBar(HIDE)
    }

    override fun onResponse(call: Call<CategoryEntity>, response: Response<CategoryEntity>) {
        presenter.stateProgressBar(HIDE)
        val category: CategoryEntity? = response.body()
        if (!response.isSuccessful || category == null || category.storesCategories.isEmpty()) {
            presenter.showAlertError(LIST_EMPTY)
            presenter.showListEmpty()
            return
        }
        val storeCategory = category.storesCategories
        presenter.showCategories(storeCategory)
    }
}