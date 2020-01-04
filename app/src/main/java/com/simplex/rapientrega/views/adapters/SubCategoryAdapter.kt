package com.simplex.rapientrega.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.objects.SubCategory

class SubCategoryAdapter(
    subCategories: List<SubCategory>,
    onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {

    private lateinit var view: View

    private var subCategories: List<SubCategory> = subCategories
    private var onItemClickListener: OnItemClickListener = onItemClickListener


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
        var subCategory: SubCategory = subCategories.get(position)
        holder.name.text = subCategory.name
        Glide.with(view).load(subCategory.photo).into(holder.photo)
        holder.itemView.setOnClickListener { onItemClickListener.run { onItemClick(subCategory) } }
    }

    interface OnItemClickListener {
        fun onItemClick(subCategory: SubCategory)
    }

}