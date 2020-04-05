package com.simplex.rapientrega.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.orders.OrderEntity
import com.simplex.rapientrega.domain.tools.FORMAT_PRICE

class OrderAdapter(
    private var orders: List<OrderEntity>,
    private var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    private lateinit var view: View

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val productCount: TextView = itemView.findViewById(R.id.tvProductCount)
        val date: TextView = itemView.findViewById(R.id.tvDate)
        val total: TextView = itemView.findViewById(R.id.tvTotal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int = orders.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order: OrderEntity = orders[position]
        holder.title.text = order.idString()
        holder.productCount.text = order.countProduct()
//        holder.date.text = order.date.toString()
        holder.total.text = FORMAT_PRICE.format(order.totalPayment)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(order) } }
    }

    interface OnItemClickListener {
        fun onItemClick(order: OrderEntity)
    }
}