package com.simplex.rapientrega.presentation.views.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.StoreCategoryEntity
import com.simplex.rapientrega.data.api.entities.StoreEntity
import com.simplex.rapientrega.domain.tools.BASE_URL
import com.simplex.rapientrega.domain.tools.STORES_MS
import com.simplex.rapientrega.domain.tools.objectToString

class CategoryAdapter(
    private var categories: List<StoreCategoryEntity>,
    private var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private lateinit var view: View

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tvName)
        var photo: ImageView = itemView.findViewById(R.id.ivPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        view = LayoutInflater.from(
            parent.context
        ).inflate(R.layout.adapter_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category: StoreCategoryEntity = categories[position]
        holder.name.text = category.name
        val image = category.image
        Glide.with(view).load(
            if (image != null) "${BASE_URL}${STORES_MS}media/${category.image}"
            else R.drawable.ic_image_black_24dp
        ).into(holder.photo)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(category.stores) } }
    }

    interface OnItemClickListener {
        fun onItemClick(stores: List<StoreEntity>)
    }
}