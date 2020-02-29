package com.simplex.rapientrega.views.activities

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.api.entities.ShoppingCartEntity
import com.simplex.rapientrega.interfaces.ShoppingCartInterface
import com.simplex.rapientrega.objects.ShoppingCart
import com.simplex.rapientrega.presenters.activities.ShoppingCartPresenter
import com.simplex.rapientrega.tools.KEY
import com.simplex.rapientrega.tools.SHOPPING_CART
import com.simplex.rapientrega.views.adapters.ShoppingCartAdapter

class ShoppingCartActivity :
    AppCompatActivity(),
    ShoppingCartInterface.View,
    View.OnClickListener,
    ShoppingCartAdapter.ShoppingCartInterface {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoppingCartAdapter
    private lateinit var total: TextView
    private lateinit var shoppingCarts: List<ShoppingCartEntity>

    private lateinit var presenter: ShoppingCartInterface.Presenter

    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        initialElements()
    }

    private fun initialElements() {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        total = findViewById(R.id.tvTotal)

        preferences = applicationContext.getSharedPreferences(KEY, 0)

        presenter = ShoppingCartPresenter(this)
        presenter.hideIncludeShoppingCart()
        presenter.consultShoppingCarts(preferences.getString(SHOPPING_CART, null))
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> {
                onBackPressed()
            }
            R.id.ivUpdate -> presenter.calculateResult(shoppingCarts)
            R.id.btAddShoppingCart -> {
                Toast.makeText(this, "Desarrollando...", Toast.LENGTH_LONG).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun showShoppingCart(shoppingCarts: List<ShoppingCartEntity>) {
        this.shoppingCarts = shoppingCarts
        presenter.calculateResult(this.shoppingCarts)
    }

    override fun updateList() {
//        Toast.makeText(this, "Sumar", Toast.LENGTH_LONG).show()
//        adapter.notifyDataSetChanged()
    }

    override fun hideIncludeShoppingCart() {
        val shoppingCart: View = findViewById(R.id.includeShoppingCart)
        shoppingCart.visibility = View.GONE
    }

    override fun addAdapter() {
    }

    override fun showResult(result: Double) {
        total.text = "$result"
    }

    override fun showShoppingCarts(products: List<ShoppingCartEntity>) {
        adapter = ShoppingCartAdapter(products, this)
        recyclerView.adapter = adapter
    }
}
