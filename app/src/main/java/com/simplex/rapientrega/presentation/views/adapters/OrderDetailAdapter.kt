package com.simplex.rapientrega.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.ProductEntity
import com.simplex.rapientrega.data.api.entities.StoreEntity
import com.simplex.rapientrega.domain.tools.FORMAT_PRICE

class OrderDetailAdapter(
    private val stores: List<StoreEntity>,
    private val products: List<ProductEntity>
) : RecyclerView.Adapter<OrderDetailAdapter.OrderDetailViewHolder>() {

    private lateinit var view: View
    private lateinit var adapter: ProductOrderAdapter

    class OrderDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout: RelativeLayout = itemView.findViewById(R.id.layout)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val linearLayout: LinearLayout = itemView.findViewById(R.id.linear_layout)
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view)
        val total: TextView = itemView.findViewById(R.id.tvTotal)
        val shippingCost: TextView = itemView.findViewById(R.id.tvShippingCost)
        val totalFooter: TextView = itemView.findViewById(R.id.tvTotalFooter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderDetailViewHolder {
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_order_detail, parent, false)
        return OrderDetailViewHolder(view)
    }

    override fun getItemCount(): Int = stores.size

    override fun onBindViewHolder(holder: OrderDetailViewHolder, position: Int) {
        val store = stores[position]
        holder.layout.setOnClickListener {
            val id = holder.linearLayout.visibility
            holder.linearLayout.visibility = if (id == View.GONE) View.VISIBLE else View.GONE
        }
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
    }

    private fun filterProducts(storeId: Int): List<ProductEntity> {
        return products
    }

    private fun totalPriceStore(products: List<ProductEntity>, costOfShipping: Double): String {
        val totalPriceProduct = products.map { it.quantity * it.price }.sum()
        return FORMAT_PRICE.format(totalPriceProduct + costOfShipping)
    }
}