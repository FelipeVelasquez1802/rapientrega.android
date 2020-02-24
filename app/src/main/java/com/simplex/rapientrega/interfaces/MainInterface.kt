package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.views.fragments.MainFragment

interface MainInterface {
    interface View {
        fun addFragment(id: Int, fragment: MainFragment)
        fun goShoppingCartActivity()
    }

    interface Presenter {
        fun addFragment(id: Int, fragment: MainFragment)
        fun goShoppingCartActivity()
    }

    interface Model {

    }
}