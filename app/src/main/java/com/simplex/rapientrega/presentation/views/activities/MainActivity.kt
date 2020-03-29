package com.simplex.rapientrega.presentation.views.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.simplex.rapientrega.R
import com.simplex.rapientrega.domain.interfaces.MainInterface
import com.simplex.rapientrega.domain.tools.HEAD
import com.simplex.rapientrega.presentation.presenters.activities.MainPresenter
import com.simplex.rapientrega.presentation.views.fragments.*

class MainActivity :
    BaseActivity(),
    MainInterface.View,
    View.OnClickListener,
    CategoryFragment.OnFragmentInteractionListener,
    ProfileFragment.OnFragmentInteractionListener,
    MainFragment.OnFragmentInteractionListener,
    OrderFragment.OnFragmentInteractionListener,
    StoreFragment.OnFragmentInteractionListener,
    SubCategoryFragment.OnFragmentInteractionListener,
    ProductFragment.OnFragmentInteractionListener,
    ProductDetailFragment.OnFragmentInteractionListener,
    MapFragment.OnFragmentInteractionListener {

    private lateinit var presenter: MainInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
        presenter.addFragment(R.id.frame_layout_main, MainFragment())
    }

    override fun layout(): Int {
        return R.layout.activity_main
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivShoppingCart -> {
                presenter.goShoppingCartActivity()
            }
            R.id.ivBack -> onBackPressed()
        }
    }

    override fun addFragment(id: Int, fragment: MainFragment) {
        supportFragmentManager.beginTransaction().add(id, fragment).commit()
    }

    override fun goShoppingCartActivity() {
        val intent = Intent(this, ShoppingCartActivity::class.java)
        intent.putExtra(HEAD, true)
        startActivity(intent)
    }
}
