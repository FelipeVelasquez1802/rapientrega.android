package com.simplex.rapientrega.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.objects.Order
import com.simplex.rapientrega.tools.FORMAT_PRICE

class OrderAdapter(orders: List<Order>, onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    private lateinit var view: View
    private var onItemClickListener: OnItemClickListener = onItemClickListener

    private var orders: List<Order> = orders


    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date: TextView = itemView.findViewById(R.id.tvDate)
        var total: TextView = itemView.findViewById(R.id.tvTotal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int = orders.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        var order: Order = orders.get(position)
        holder.date.text = order.date
        holder.total.text = FORMAT_PRICE.format(order.total)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(order) } }
    }

    interface OnItemClickListener {
        fun onItemClick(order: Order)
    }
}