package com.simplex.rapientrega.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.objects.Product
import com.simplex.rapientrega.tools.FORMAT_PRICE

class ProductAdapter(products: List<Product>, onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var view: View

    private var products: List<Product> = products
    private var onItemClickListener: OnItemClickListener = onItemClickListener

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.ivPhoto)
        var name: TextView = itemView.findViewById(R.id.tvName)
        var price: TextView = itemView.findViewById(R.id.tvPrice)
        var description: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        view = LayoutInflater.from(
            parent.context
        ).inflate(R.layout.adapter_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var product: Product = products.get(position)
        Glide.with(view).load(product.photo).into(holder.photo)
        holder.name.text = product.name
        holder.description.text = product.description
        holder.price.text = FORMAT_PRICE.format(product.price)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(product) } }
    }

    interface OnItemClickListener {
        fun onItemClick(product: Product)
    }

}