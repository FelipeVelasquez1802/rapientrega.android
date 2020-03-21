package com.simplex.rapientrega.presentation.views.activities

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.ShoppingCartEntity
import com.simplex.rapientrega.domain.interfaces.ShoppingCartInterface
import com.simplex.rapientrega.domain.tools.ORDER
import com.simplex.rapientrega.domain.tools.SHOPPING_CART
import com.simplex.rapientrega.presentation.presenters.activities.ShoppingCartPresenter
import com.simplex.rapientrega.presentation.views.adapters.ShoppingCartAdapter

class ShoppingCartActivity :
    BaseActivity(),
    ShoppingCartInterface.View,
    View.OnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoppingCartAdapter
    private lateinit var total: TextView
    private val shoppingCarts: ArrayList<ShoppingCartEntity> = ArrayList()

    private lateinit var presenter: ShoppingCartInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ShoppingCartAdapter(this, shoppingCarts, dialogProduct)
        recyclerView.adapter = adapter
        total = findViewById(R.id.tvTotal)
        presenter = ShoppingCartPresenter(this)
        presenter.consultShoppingCarts(preferences.getString(SHOPPING_CART, null))
    }

    override fun layout(): Int {
        return R.layout.activity_shopping_cart
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> {
                onBackPressed()
            }
            R.id.btAddShoppingCart -> {
                presenter.convertProducts(shoppingCarts, preferences.getString(ORDER, null))
            }
        }
    }

    override fun addAdapter() {
    }

    override fun showShoppingCarts(shoppingCarts: List<ShoppingCartEntity>) {
        changeShoppingCarts(shoppingCarts)
    }

    override fun saveProducts(string: String?) {
        val editor = preferences.edit()
        editor.putString(ORDER, string)
        editor.apply()
    }

    override fun deleteProducts() {
        val editor = preferences.edit()
        editor.remove(SHOPPING_CART)
        editor.apply()
    }

    override fun goMainActivity() {
//        val intent = Intent(this, MainActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//        startActivity(intent)
        onBackPressed()
    }

    override fun showMessage(id: Int) {
        Toast.makeText(this, getString(id), Toast.LENGTH_LONG).show()
    }

    override fun changeList(shoppingCarts: List<ShoppingCartEntity>) {
        changeShoppingCarts(shoppingCarts)
    }

    override fun updateTotal(total: String) {
        this.total.text = total
    }

    private fun changeShoppingCarts(shoppingCarts: List<ShoppingCartEntity>) {
        this.shoppingCarts.clear()
        this.shoppingCarts.addAll(shoppingCarts)
        adapter.notifyDataSetChanged()
    }
}
