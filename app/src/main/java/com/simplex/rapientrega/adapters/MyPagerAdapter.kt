package com.simplex.rapientrega.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentManager
import com.simplex.rapientrega.fragments.CategoryFragment
import com.simplex.rapientrega.fragments.OrdersFragment
import com.simplex.rapientrega.fragments.ProfileFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                CategoryFragment.newInstance()
            }
            1->{
                OrdersFragment.newInstance()
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