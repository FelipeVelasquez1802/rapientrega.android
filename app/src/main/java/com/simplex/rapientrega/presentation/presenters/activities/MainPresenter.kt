package com.simplex.rapientrega.presentation.presenters.activities

import android.content.SharedPreferences
import com.simplex.rapientrega.R
import com.simplex.rapientrega.domain.interfaces.MainInterface
import com.simplex.rapientrega.domain.model.activities.MainModel
import com.simplex.rapientrega.domain.tools.CITY_USER
import com.simplex.rapientrega.presentation.views.fragments.MainFragment

class MainPresenter(private val view: MainInterface.View) : MainInterface.Presenter {

    private val model = MainModel(this)
    override fun initial() {
        view.initialElements()
        view.initialObjects()
        view.havePermissions()
    }

    override fun havePermissions() {
        view.hideMessageNotPermissions()
        view.havePermissions()
    }

    override fun showDialogLocation() {
        view.showDialogLocation()
    }

    override fun hideDialogLocation() {
        view.hideDialogLocation()
    }

    override fun addFragment(id: Int, fragment: MainFragment) {
        view.addFragment(id, fragment)
    }

    override fun goShoppingCartActivity() {
        view.goShoppingCartActivity()
    }

    override fun showMessageNotPermissions() {
        view.showMessageNotPermissions()
    }

    override fun hideMessageNotPermissions() {
        view.hideMessageNotPermissions()
    }

    override fun verifyDataInitial(preferences: SharedPreferences) {
        val city = preferences.getString(CITY_USER, null)
        if (city == null) view.showDialogCity()
        else view.addFragment(R.id.frame_layout_main, MainFragment())
    }

}