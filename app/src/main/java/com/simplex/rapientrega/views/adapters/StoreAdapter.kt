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
        view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_store, parent, false)
        return ProviderViewHolder(view)
    }

    override fun getItemCount(): Int = stores.size

    override fun onBindViewHolder(holder: ProviderViewHolder, position: Int) {
        val store: StoreEntity = stores[position]
        Glide.with(view).load(store.imageAbsolute()).into(holder.photo)
        holder.name.text = store.name
        holder.description.text = store.description
        holder.serviceTime.text = store.serviceTime()
        holder.shippingCost.text = FORMAT_PRICE.format(store.costOfShipping)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(store.id) } }
    }

    class ProviderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.ivPhoto)
        var name: TextView = itemView.findViewById(R.id.tvName)
        var description: TextView = itemView.findViewById(R.id.tvDescription)
        var serviceTime: TextView = itemView.findViewById(R.id.tvServiceTime)
        var shippingCost: TextView = itemView.findViewById(R.id.tvShippingCost)
    }

    interface OnItemClickListener {
        fun onItemClick(store_id: Int)
    }
}