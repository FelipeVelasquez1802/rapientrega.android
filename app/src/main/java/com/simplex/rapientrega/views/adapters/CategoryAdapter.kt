package com.simplex.rapientrega.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.objects.Category

class CategoryAdapter(categories: List<Category>, onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private lateinit var view: View
    private var categories: List<Category> = categories

    private var onItemClickListener: OnItemClickListener = onItemClickListener

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
        var category: Category = categories.get(position)
        holder.name.text = category.name
        Glide.with(view).load(category.photo).into(holder.photo)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(category) } }
    }

    interface OnItemClickListener {
        fun onItemClick(category: Category)
    }
}