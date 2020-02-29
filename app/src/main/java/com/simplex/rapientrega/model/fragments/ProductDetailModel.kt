package com.simplex.rapientrega.model.fragments

import com.simplex.rapientrega.api.entities.ProductEntity
import com.simplex.rapientrega.api.entities.ShoppingCartEntity
import com.simplex.rapientrega.interfaces.ProductDetailInterface
import com.simplex.rapientrega.tools.objectToString
import com.simplex.rapientrega.tools.toListProduct

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