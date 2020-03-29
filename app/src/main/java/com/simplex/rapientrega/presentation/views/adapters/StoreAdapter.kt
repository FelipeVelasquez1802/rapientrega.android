package com.simplex.rapientrega.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.StoreEntity
import com.simplex.rapientrega.domain.tools.FORMAT_PRICE

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
        Glide.with(view).load(
            if (store.image == null) R.drawable.ic_image_black_24dp
            else store.imageAbsolute()
        ).into(holder.photo)
        holder.name.text = store.name
        holder.description.text = store.description
        holder.serviceTime.text = store.serviceTime()
        holder.shippingCost.text = FORMAT_PRICE.format(store.costOfShipping)
        holder.qualification.text = store.qualificationString()
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(store.id) } }
    }

    class ProviderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.ivPhoto)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val serviceTime: TextView = itemView.findViewById(R.id.tvServiceTime)
        val shippingCost: TextView = itemView.findViewById(R.id.tvShippingCost)
        val qualification: TextView = itemView.findViewById(R.id.tvQualification)
    }

    interface OnItemClickListener {
        fun onItemClick(store_id: Int)
    }
}