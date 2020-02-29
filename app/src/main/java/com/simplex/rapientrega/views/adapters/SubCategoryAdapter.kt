package com.simplex.rapientrega.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.api.entities.ProductCategoriesEntity
import com.simplex.rapientrega.api.entities.ProductEntity
import com.simplex.rapientrega.objects.Product

class SubCategoryAdapter(
    private var subCategories: List<ProductCategoriesEntity>,
    private var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {

    private lateinit var view: View


    class SubCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tvName)
        var photo: ImageView = itemView.findViewById(R.id.ivPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_sub_category, parent, false)
        return SubCategoryViewHolder(view)
    }

    override fun getItemCount(): Int = subCategories.size

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        val subCategory: ProductCategoriesEntity = subCategories[position]
        holder.name.text = subCategory.name
        Glide.with(view).load(subCategory.imageAbsolute()).into(holder.photo)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(subCategory.products) } }
    }

    interface OnItemClickListener {
        fun onItemClick(products: List<ProductEntity>)
    }

}