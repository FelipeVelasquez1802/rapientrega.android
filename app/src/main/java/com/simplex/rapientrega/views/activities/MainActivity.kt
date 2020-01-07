package com.simplex.rapientrega.views.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.simplex.rapientrega.R
import com.simplex.rapientrega.views.fragments.*

class MainActivity :
    AppCompatActivity(),
    View.OnClickListener,
    CategoryFragment.OnFragmentInteractionListener,
    ProfileFragment.OnFragmentInteractionListener,
    MainFragment.OnFragmentInteractionListener,
    OrderFragment.OnFragmentInteractionListener,
    ProviderFragment.OnFragmentInteractionListener,
    SubCategoryFragment.OnFragmentInteractionListener,
    ProductFragment.OnFragmentInteractionListener,
    ProductDetailFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialElements()
    }

    private fun initialElements() {
        var fragment: Fragment = MainFragment()
        fragment.arguments = intent.extras
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, fragment)
            .addToBackStack(null).commit()
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> {
                onBackPressed()
            }
        }
    }
}