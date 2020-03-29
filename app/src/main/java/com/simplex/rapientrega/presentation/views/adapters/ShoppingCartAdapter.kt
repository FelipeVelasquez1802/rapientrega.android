package com.simplex.rapientrega.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.shoppingcart.ShoppingCartEntity
import com.simplex.rapientrega.domain.interfaces.ShoppingCartInterface
import com.simplex.rapientrega.presentation.presenters.adapters.ShoppingCartPresenter

private const val YES = "Sí"

class ShoppingCartAdapter(
    private val view: ShoppingCartInterface.View,
    private var shoppingCarts: ArrayList<ShoppingCartEntity>,
    private val dialog: AlertDialog
) :
    RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder>() {

    private lateinit var itemView: View
    private lateinit var presenter: ShoppingCartInterface.AdapterPresenter

    class ShoppingCartViewHolder(itemView: View, val activity: ShoppingCartInterface.View) :
        RecyclerView.ViewHolder(itemView),
        ShoppingCartInterface.AdapterView {
        var photo: ImageView = itemView.findViewById(R.id.ivPhoto)
        var name: TextView = itemView.findViewById(R.id.tvName)
        var count: TextView = itemView.findViewById(R.id.tvCount)
        val delete: ImageView = itemView.findViewById(R.id.ivDelete)
        var left: Button = itemView.findViewById(R.id.btLeft)
        var right: Button = itemView.findViewById(R.id.btMore)

        override fun subtract(value: Int, flag: Boolean) {
            count.text = "$value"
            left.isEnabled = flag
        }

        override fun add(value: Int, flag: Boolean) {
            count.text = "$value"
            right.isEnabled = flag
        }

        override fun updateTotal(total: Double) {
            activity.updateTotal("$total")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_shopping_cart, parent, false)
        val shoppingCartViewHolder = ShoppingCartViewHolder(itemView, view)
        presenter = ShoppingCartPresenter(shoppingCartViewHolder)
        return shoppingCartViewHolder
    }

    override fun getItemCount(): Int = shoppingCarts.size

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        val shoppingCart: ShoppingCartEntity = shoppingCarts[position]
        Glide.with(itemView).load(shoppingCart.product.imageAbsolute()).into(holder.photo)
        holder.name.text = shoppingCart.product.name
        holder.count.text = "${shoppingCart.count}"
        holder.delete.setOnClickListener {
            dialog.setButton(
                AlertDialog.BUTTON_POSITIVE,
                YES
            ) { _, _ ->
                presenter.deleteRow(shoppingCarts, position)
                view.updateTotal(
                    "${presenter.calculate(
                        holder.count.text.toString(), shoppingCart.id, shoppingCarts
                    )}"
                )
                this.notifyDataSetChanged()
            }
            dialog.show()
        }
        holder.left.setOnClickListener {
            presenter.left(holder.count.text.toString(), shoppingCart.id, shoppingCarts)
        }
        holder.right.setOnClickListener {
            presenter.right(holder.count.text.toString(), shoppingCart.id, shoppingCarts)
        }
        initialView(holder.left, shoppingCart.count, shoppingCart.product.price)
    }

    private fun initialView(left: Button, count: Int, price: Double) {
        var id = true
        if (count == 1) {
            id = false
        }
        left.isEnabled = id
        view.updateTotal("${count * price}")
    }

}