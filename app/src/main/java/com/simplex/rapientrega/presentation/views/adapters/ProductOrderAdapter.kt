package com.simplex.rapientrega.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.ProductEntity
import com.simplex.rapientrega.domain.tools.FORMAT_PRICE

class ProductOrderAdapter(private val products: List<ProductEntity>) :
    RecyclerView.Adapter<ProductOrderAdapter.ProductOrderViewHolder>() {

    private lateinit var itemView: View

    class ProductOrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.ivPhoto)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val count: TextView = itemView.findViewById(R.id.tvCount)
        val total: TextView = itemView.findViewById(R.id.tvTotal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductOrderViewHolder {
        itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_product_order, parent, false)
        return ProductOrderViewHolder(itemView)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductOrderViewHolder, position: Int) {
        val product = products[position]
        Glide.with(holder.itemView).load(product.imageAbsolute()).into(holder.photo)
        holder.name.text = product.name
        val quantity = product.quantity
        holder.count.text = quantity.toString()
        val totalPrice = product.price * quantity
        holder.total.text = FORMAT_PRICE.format(totalPrice)
    }
}