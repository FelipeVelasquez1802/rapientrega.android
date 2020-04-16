package com.simplex.rapientrega.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.orders.OrderEntity
import com.simplex.rapientrega.domain.tools.FORMAT_PRICE

const val UNASSIGNED = "unassigned"
const val IN_PROGRESS = "in_progress"
const val CANCELED = "canceled"
const val CANCELED_BY_USER = "canceled_by_user"
const val CANCELED_BY_NOT_DELIVERYMAN = "canceled_by_not_deliveryman"
const val COMPLETED = "completed"

class OrderAdapter(
    private var orders: List<OrderEntity>,
    private var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    private lateinit var view: View

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val state: TextView = itemView.findViewById(R.id.tvState)
        val productCount: TextView = itemView.findViewById(R.id.tvProductCount)
        val date: TextView = itemView.findViewById(R.id.tvDate)
        val total: TextView = itemView.findViewById(R.id.tvTotal)
        val map: ImageButton = itemView.findViewById(R.id.ibMap)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int = orders.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order: OrderEntity = orders[position]
        holder.title.text = order.idString()
        holder.state.text = getTextState(order.state)
        styleState(holder.state, order.state)
        holder.productCount.text = order.countProduct()
        holder.total.text = FORMAT_PRICE.format(order.totalPayment)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(order) } }
        holder.map.setOnClickListener { onItemClickListener.run { goMap() } }
    }

    private fun styleState(state: TextView, value: String) {
        state.setBackgroundResource(
            when (value) {
                COMPLETED -> R.drawable.theme_completed_order
                CANCELED, CANCELED_BY_USER, CANCELED_BY_NOT_DELIVERYMAN -> R.drawable.theme_canceled_order
                IN_PROGRESS -> R.drawable.theme_in_progress_order
                else -> R.drawable.theme_unassigned_order
            }
        )
        state.setTextColor(
            ContextCompat.getColor(
                view.context,
                when (value) {
                    COMPLETED -> android.R.color.holo_green_light
                    CANCELED, CANCELED_BY_USER, CANCELED_BY_NOT_DELIVERYMAN -> R.color.colorPrimaryDark
                    IN_PROGRESS -> android.R.color.holo_orange_light
                    else -> android.R.color.darker_gray
                }
            )
        )
    }

    private fun getTextState(state: String): String {
        return view.context.getString(
            when (state) {
                COMPLETED -> R.string.completed
                CANCELED, CANCELED_BY_USER, CANCELED_BY_NOT_DELIVERYMAN -> R.string.canceled
                IN_PROGRESS -> R.string.in_progress
                else -> R.string.unassigned
            }
        )
    }

    interface OnItemClickListener {
        fun onItemClick(order: OrderEntity)
        fun goMap()
    }
}