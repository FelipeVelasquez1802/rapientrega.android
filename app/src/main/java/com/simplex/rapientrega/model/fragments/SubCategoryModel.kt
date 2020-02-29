package com.simplex.rapientrega.model.fragments

import com.simplex.rapientrega.api.RepositoryImpl
import com.simplex.rapientrega.api.entities.ProductKeyEntity
import com.simplex.rapientrega.interfaces.SubCategoryInterface
import com.simplex.rapientrega.tools.ERROR
import com.simplex.rapientrega.tools.LIST_EMPTY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubCategoryModel(private val presenter: SubCategoryInterface.Presenter) :
    SubCategoryInterface.Model,
    Callback<ProductKeyEntity> {

    private val repository: RepositoryImpl = RepositoryImpl()

    override fun consultSubCategories(id: Int) {
//        presenter.showSubCategories(SubCategoryTest().subCategoriesList())
        repository.service().products().enqueue(this)
    }

    override fun onFailure(call: Call<ProductKeyEntity>, t: Throwable) {
        presenter.showAlertMessage(ERROR)
    }

    override fun onResponse(call: Call<ProductKeyEntity>, response: Response<ProductKeyEntity>) {
        val productCategory: ProductKeyEntity? = response.body()
        if (productCategory != null) {
            presenter.showSubCategories(productCategory.productCategories)
        } else presenter.showAlertMessage(LIST_EMPTY)
    }
}