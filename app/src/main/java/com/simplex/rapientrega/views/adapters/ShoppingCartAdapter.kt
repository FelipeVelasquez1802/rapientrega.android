package com.simplex.rapientrega.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.objects.ShoppingCart

class ShoppingCartAdapter(
    private var shoppingCarts: List<ShoppingCart>,
    private var shoppingCartInterface: ShoppingCartInterface
) :
    RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder>() {

    private lateinit var view: View

    class ShoppingCartViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var photo: ImageView = itemView.findViewById(R.id.ivPhoto)
        var name: TextView = itemView.findViewById(R.id.tvName)
        var count: TextView = itemView.findViewById(R.id.tvCount)
        var less: Button = itemView.findViewById(R.id.btLess)
        var right: Button = itemView.findViewById(R.id.btMore)

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.btLess -> {
                    less()
                }
                R.id.btMore -> {
                    right()
                }
            }
        }

        @SuppressLint("SetTextI18n")
        fun less() {
            val count = this.count.text.toString().toInt() - 1
            this.count.text = "${count})"
        }

        @SuppressLint("SetTextI18n")
        fun right() {
            val count = this.count.text.toString().toInt() + 1
            this.count.text = "${count})"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_shopping_cart, parent, false)
        shoppingCartInterface.run { showShoppingCart(shoppingCarts) }
        return ShoppingCartViewHolder(view)
    }

    override fun getItemCount(): Int = shoppingCarts.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        var shoppingCart: ShoppingCart = shoppingCarts[position]
        Glide.with(view).load(shoppingCart.product.photo).into(holder.photo)
        holder.name.text = shoppingCart.product.name
        holder.count.text = shoppingCart.countFormat()
        holder.less.setOnClickListener {
            val count = holder.count.text.toString().toInt() - 1
            if (count >= 0) {
                holder.count.text = "$count"
            } else {
                holder.less.isEnabled = false
            }
            shoppingCarts[position].count = count
            shoppingCartInterface.run { updateList() }
        }
        holder.right.setOnClickListener {
            val count = holder.count.text.toString().toInt()
            if (count == 0) {
                holder.less.isEnabled = true
            }
            holder.count.text = "${count + 1}"
            shoppingCarts[position].count = count + 1
            shoppingCartInterface.run { updateList() }
        }
    }

    interface ShoppingCartInterface {
        fun showShoppingCart(shoppingCarts: List<ShoppingCart>)
        fun updateList()
    }

}