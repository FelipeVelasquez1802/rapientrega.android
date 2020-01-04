package com.simplex.rapientrega.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.objects.Provider
import com.simplex.rapientrega.tools.FORMAT_PRICE

class ProviderAdapter(providers: List<Provider>, onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<ProviderAdapter.ProviderViewHolder>() {

    private var providers: List<Provider> = providers

    private lateinit var view: View
    private var onItemClickListener: OnItemClickListener = onItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProviderViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_provider, parent, false)
        return ProviderViewHolder(view)
    }

    override fun getItemCount(): Int = providers.size

    override fun onBindViewHolder(holder: ProviderViewHolder, position: Int) {
        var provider: Provider = providers.get(position)
        Glide.with(view).load(provider.photo).into(holder.photo)
        holder.name.text = provider.name
        holder.category.text = provider.category
        isOpen(holder.open, provider.isOpen)
        isOpen(holder.closed, !provider.isOpen)
        holder.minimumOrder.text = FORMAT_PRICE.format(provider.minimumOrder)
        holder.shipping_cost.text = FORMAT_PRICE.format(provider.shippingCost)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(provider) } }
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
        var shipping_cost: TextView = itemView.findViewById(R.id.tvShippingCost)
    }

    interface OnItemClickListener {
        fun onItemClick(provider: Provider)
    }
}