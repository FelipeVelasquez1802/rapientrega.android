package com.simplex.rapientrega.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.ProductEntity
import com.simplex.rapientrega.data.api.entities.StoreEntity
import com.simplex.rapientrega.domain.tools.FORMAT_PRICE

const val FOOTER_KEY = 1

class OrderDetailAdapter(
    private val stores: List<StoreEntity>,
    private val products: List<ProductEntity>,
    private val totalPayment: String
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var view: View
    private lateinit var adapter: ProductOrderAdapter

    class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val total: TextView = itemView.findViewById(R.id.tvTotal)
    }

    class OrderDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.ivPhoto)
        val layout: RelativeLayout = itemView.findViewById(R.id.layout)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val linearLayout: LinearLayout = itemView.findViewById(R.id.linear_layout)
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view)
        val total: TextView = itemView.findViewById(R.id.tvTotal)
        val shippingCost: TextView = itemView.findViewById(R.id.tvShippingCost)
        val totalFooter: TextView = itemView.findViewById(R.id.tvTotalFooter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            FOOTER_KEY -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.footer_order, parent, false)
                FooterViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_order_detail, parent, false)
                OrderDetailViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int = stores.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is OrderDetailViewHolder) {
            val store = stores[position]
            holder.layout.setOnClickListener {
                val id = holder.linearLayout.visibility
                holder.linearLayout.visibility = if (id == View.GONE) View.VISIBLE else View.GONE
            }
            Glide.with(holder.itemView).load(store.imageAbsolute()).into(holder.photo)
            holder.name.text = store.name
            holder.recyclerView.setHasFixedSize(true)
            holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)

            val products = filterProducts(store.id)
            adapter = ProductOrderAdapter(products)
            holder.recyclerView.adapter = adapter
            val totalPriceStore = totalPriceStore(products, store.costOfShipping)
            holder.total.text = totalPriceStore
            holder.shippingCost.text = FORMAT_PRICE.format(store.costOfShipping)
            holder.totalFooter.text = totalPriceStore
        } else if (holder is FooterViewHolder) {
            holder.total.text = totalPayment
        }
    }

    private fun filterProducts(storeId: Int): List<ProductEntity> {
        return products.filter { storeId == it.storeId }
    }

    private fun totalPriceStore(products: List<ProductEntity>, costOfShipping: Double): String {
        val totalPriceProduct = products.map { it.quantity * it.price }.sum()
        return FORMAT_PRICE.format(totalPriceProduct + costOfShipping)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == stores.size) FOOTER_KEY
        else super.getItemViewType(position)
    }
}