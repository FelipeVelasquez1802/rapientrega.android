package com.simplex.rapientrega.presentation.presenters.fragments

import android.os.Bundle
import android.view.View
import com.simplex.rapientrega.domain.interfaces.MapInterface
import com.simplex.rapientrega.domain.model.fragments.MapModel

class MapPresenter(private val view: MapInterface.View) : MapInterface.Presenter {
    private val model: MapInterface.Model = MapModel(this)
    override fun initial(savedInstanceState: Bundle?) {
        view.initialElement(savedInstanceState)
        view.addListener()
    }

    override fun stateProgressBar(state: Boolean) {
        view.stateProgressBar(if (state) View.VISIBLE else View.GONE)
    }
}