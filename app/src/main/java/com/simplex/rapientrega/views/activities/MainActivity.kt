package com.simplex.rapientrega.views.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.MainInterface
import com.simplex.rapientrega.presenters.activities.MainPresenter
import com.simplex.rapientrega.views.fragments.*

class MainActivity :
    AppCompatActivity(),
    MainInterface.View,
    View.OnClickListener,
    CategoryFragment.OnFragmentInteractionListener,
    ProfileFragment.OnFragmentInteractionListener,
    MainFragment.OnFragmentInteractionListener,
    OrderFragment.OnFragmentInteractionListener,
    ProviderFragment.OnFragmentInteractionListener,
    SubCategoryFragment.OnFragmentInteractionListener,
    ProductFragment.OnFragmentInteractionListener,
    ProductDetailFragment.OnFragmentInteractionListener,
    MapFragment.OnFragmentInteractionListener {

    private lateinit var presenter: MainInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
        presenter.addFragment(R.id.frame_layout_main, MainFragment())
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> {
                onBackPressed()
            }
            R.id.ivShoppingCart -> {
                presenter.goShoppingCartActivity()
            }
        }
    }

    override fun addFragment(id: Int, fragment: MainFragment) {
        supportFragmentManager.beginTransaction().add(id, fragment).commit()
    }

    override fun goShoppingCartActivity() {
        val intent = Intent(this, ShoppingCartActivity::class.java)
        startActivity(intent)
    }
}
