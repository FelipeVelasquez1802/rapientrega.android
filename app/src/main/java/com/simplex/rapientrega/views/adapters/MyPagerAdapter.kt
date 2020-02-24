package com.simplex.rapientrega.views.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.simplex.rapientrega.views.fragments.CategoryFragment
import com.simplex.rapientrega.views.fragments.OrderFragment
import com.simplex.rapientrega.views.fragments.ProfileFragment

class MyPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
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
                null
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

}