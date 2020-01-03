package com.simplex.rapientrega.views

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.simplex.rapientrega.R
import com.simplex.rapientrega.fragments.CategoryFragment

class MainActivity :
    AppCompatActivity(), CategoryFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialElements()
    }

    private fun initialElements() {
        var fragment: Fragment = CategoryFragment()
        fragment.arguments = intent.extras
        supportFragmentManager.beginTransaction().add(R.id.frame_layout, fragment).commit()
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}
