package com.simplex.rapientrega.model.fragments

import com.simplex.rapientrega.api.RepositoryImpl
import com.simplex.rapientrega.api.entities.CategoryEntity
import com.simplex.rapientrega.interfaces.CategoryInterface
import com.simplex.rapientrega.tools.ERROR
import com.simplex.rapientrega.tools.HIDE
import com.simplex.rapientrega.tools.LIST_EMPTY
import com.simplex.rapientrega.tools.SHOW
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryModel(private val presenter: CategoryInterface.Presenter) :
    CategoryInterface.Model,
    Callback<CategoryEntity> {

    private val repository: RepositoryImpl = RepositoryImpl()

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
        val storeCategory: CategoryEntity? = response.body()
        if (storeCategory != null) {
            presenter.showCategories(storeCategory.storesCategories)
        } else presenter.showAlertError(LIST_EMPTY)
        presenter.stateProgressBar(HIDE)
    }
}