package com.simplex.rapientrega.domain.interfaces

import android.content.SharedPreferences
import com.simplex.rapientrega.presentation.views.fragments.MainFragment

interface MainInterface {
    interface View {
        fun initialElements()
        fun initialObjects()
        fun addListener()
        fun havePermissions()
        fun showMessageNotPermissions()
        fun hideMessageNotPermissions()
        fun showDialogLocation()
        fun hideDialogLocation()
        fun showDialogCity()
        fun addFragment(id: Int, fragment: MainFragment)
        fun goShoppingCartActivity()
    }

    interface Presenter {
        fun initial()
        fun havePermissions()
        fun showDialogLocation()
        fun hideDialogLocation()
        fun addFragment(id: Int, fragment: MainFragment)
        fun goShoppingCartActivity()
        fun showMessageNotPermissions()
        fun hideMessageNotPermissions()
        fun verifyDataInitial(preferences: SharedPreferences)
    }

    interface Model {

    }
}