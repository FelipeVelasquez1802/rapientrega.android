package com.simplex.rapientrega.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simplex.rapientrega.R
import com.simplex.rapientrega.tests.ShoppingCartTest
import com.simplex.rapientrega.views.adapters.ShoppingCartAdapter

class ShoppingCartActivity :
    AppCompatActivity(),
    View.OnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoppingCartAdapter

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
        adapter = ShoppingCartAdapter(ShoppingCartTest().shoppingCartList())
        recyclerView.adapter = adapter

//        count = findViewById(R.id.tvCount)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> {
                onBackPressed()
            }
        }
    }
}
