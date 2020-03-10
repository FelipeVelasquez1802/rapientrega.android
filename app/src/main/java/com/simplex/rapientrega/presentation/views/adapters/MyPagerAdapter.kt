package com.simplex.rapientrega.presentation.views.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.simplex.rapientrega.presentation.views.fragments.CategoryFragment
import com.simplex.rapientrega.presentation.views.fragments.OrderFragment
import com.simplex.rapientrega.presentation.views.fragments.ProfileFragment

class MyPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {

    override fun getItem(position: Int): Fragment {
        Log.d("MyPagerAdapter", "Sí entró $position")
        return when (position) {
            0 -> {
                CategoryFragment.newInstance()
            }
            1 -> {
                OrderFragment.newInstance()
            }
            2 -> {
                ProfileFragment.newInstance()
            }
            else -> {
                CategoryFragment.newInstance()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

}