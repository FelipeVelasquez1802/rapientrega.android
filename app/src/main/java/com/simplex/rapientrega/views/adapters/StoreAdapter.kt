package com.simplex.rapientrega.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.api.entities.StoreEntity
import com.simplex.rapientrega.tools.FORMAT_PRICE

class StoreAdapter(
    private var stores: List<StoreEntity>,
    private var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<StoreAdapter.ProviderViewHolder>() {

    private lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProviderViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_provider, parent, false)
        return ProviderViewHolder(view)
    }

    override fun getItemCount(): Int = stores.size

    override fun onBindViewHolder(holder: ProviderViewHolder, position: Int) {
        val store: StoreEntity = stores[position]
        Glide.with(view).load(store.imageAbsolute()).into(holder.photo)
        holder.name.text = store.name
//        holder.category.text = store.category
//        isOpen(holder.open, store.isOpen)
//        isOpen(holder.closed, !store.isOpen)
//        holder.minimumOrder.text = FORMAT_PRICE.format(store.minimumOrder)
        holder.shippingCost.text = FORMAT_PRICE.format(store.costOfShipping)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(store.id) } }
    }

    private fun isOpen(field: TextView, flag: Boolean) {
        field.visibility = if (flag) View.VISIBLE else View.GONE
    }

    class ProviderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.ivPhoto)
        var name: TextView = itemView.findViewById(R.id.tvName)
        var category: TextView = itemView.findViewById(R.id.tvCategory)
        var open: TextView = itemView.findViewById(R.id.tvOpen)
        var closed: TextView = itemView.findViewById(R.id.tvClosed)
        var minimumOrder: TextView = itemView.findViewById(R.id.tvMinimumOrder)
        var shippingCost: TextView = itemView.findViewById(R.id.tvShippingCost)
    }

    interface OnItemClickListener {
        fun onItemClick(store_id: Int)
    }
}