package com.simplex.rapientrega.presenters.fragments

import android.view.View
import com.simplex.rapientrega.interfaces.StoreInterface
import com.simplex.rapientrega.model.fragments.StoreModel
import com.simplex.rapientrega.tools.HIDE
import com.simplex.rapientrega.tools.SHOW

class StorePresenter(private val view: StoreInterface.View) : StoreInterface.Presenter {
    private val model: StoreInterface.Model = StoreModel(this)

    override fun consultProviders() {
        model.consultProviders()
    }
}