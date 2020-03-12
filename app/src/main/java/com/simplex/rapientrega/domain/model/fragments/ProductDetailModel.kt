package com.simplex.rapientrega.domain.model.fragments

import com.simplex.rapientrega.data.api.entities.ProductEntity
import com.simplex.rapientrega.data.api.entities.ShoppingCartEntity
import com.simplex.rapientrega.domain.interfaces.ProductDetailInterface
import com.simplex.rapientrega.domain.tools.objectToString
import com.simplex.rapientrega.domain.tools.toListProduct

class ProductDetailModel(private val presenter: ProductDetailInterface.Presenter) :
    ProductDetailInterface.Model {

    private fun searchProduct(
        product: ProductEntity, count: Int, list: List<ShoppingCartEntity>
    ): List<ShoppingCartEntity> {
        val listNew = list.dropWhile { it.product.id == product.id }
        val shoppingCartEntity = ShoppingCartEntity()
        shoppingCartEntity.product = product
        shoppingCartEntity.count = count
        return listNew.plus(shoppingCartEntity)
    }

    override fun addProductToCar(product: ProductEntity, count: Int, list: String?) {
        val listProduct = toListProduct(list)
        presenter.addSharedPreference(objectToString(searchProduct(product, count, listProduct)))
    }
}