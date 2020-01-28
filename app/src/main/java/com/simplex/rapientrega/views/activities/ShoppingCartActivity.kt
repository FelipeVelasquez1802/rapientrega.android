package com.simplex.rapientrega.views.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.objects.ShoppingCart
import com.simplex.rapientrega.tests.ShoppingCartTest
import com.simplex.rapientrega.views.adapters.ShoppingCartAdapter

class ShoppingCartActivity :
    AppCompatActivity(),
    View.OnClickListener,
    ShoppingCartAdapter.ShoppingCartInterface {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoppingCartAdapter
    private lateinit var total: TextView
    private lateinit var shoppingCarts: List<ShoppingCart>

//    private lateinit var count: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        initialElements()
    }

    private fun initialElements() {
        var shoppingCart: View = findViewById(R.id.includeShoppingCart)
        shoppingCart.visibility = View.GONE

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ShoppingCartAdapter(ShoppingCartTest().shoppingCartList(), this)
        recyclerView.adapter = adapter

        total = findViewById(R.id.tvTotal)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> {
                onBackPressed()
            }
            R.id.ivUpdate -> {
                total.text = "$ ${calculateTotalPrice()}"
            }
            R.id.btPay -> {
                Toast.makeText(this, "Desarrollando...", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun calculateTotalPrice(): Double {
        return shoppingCarts.map { it.product.price * it.count }.sum()
    }

    @SuppressLint("SetTextI18n")
    override fun showShoppingCart(shoppingCarts: List<ShoppingCart>) {
        this.shoppingCarts = shoppingCarts
        total.text = "$ ${calculateTotalPrice()}"
    }

    override fun updateList() {
//        Toast.makeText(this, "Sumar", Toast.LENGTH_LONG).show()
//        adapter.notifyDataSetChanged()
    }
}
