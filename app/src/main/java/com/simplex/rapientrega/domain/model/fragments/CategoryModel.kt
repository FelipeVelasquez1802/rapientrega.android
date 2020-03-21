package com.simplex.rapientrega.domain.model.fragments

import com.simplex.rapientrega.data.api.entities.CategoryEntity
import com.simplex.rapientrega.data.api.repositories.RepositoryImpl
import com.simplex.rapientrega.domain.interfaces.CategoryInterface
import com.simplex.rapientrega.domain.tools.ERROR
import com.simplex.rapientrega.domain.tools.HIDE
import com.simplex.rapientrega.domain.tools.LIST_EMPTY
import com.simplex.rapientrega.domain.tools.SHOW
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryModel(private val presenter: CategoryInterface.Presenter) :
    CategoryInterface.Model,
    Callback<CategoryEntity> {

    private val repository: RepositoryImpl =
        RepositoryImpl()

    override fun consultCategories() {
        presenter.stateProgressBar(SHOW)
        repository.service().stores().enqueue(this)
    }

    override fun onFailure(call: Call<CategoryEntity>, t: Throwable) {
        presenter.showAlertError(ERROR)
        presenter.stateProgressBar(HIDE)
    }

    override fun onResponse(
        call: Call<CategoryEntity>, response: Response<CategoryEntity>
    ) {
        if (response.isSuccessful) {
            val storeCategory: CategoryEntity? = response.body()
            presenter.showCategories(storeCategory?.storesCategories)
        } else presenter.showAlertError(LIST_EMPTY)
        presenter.stateProgressBar(HIDE)
    }
}