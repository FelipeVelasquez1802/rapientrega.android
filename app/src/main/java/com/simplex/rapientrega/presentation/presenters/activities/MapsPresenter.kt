package com.simplex.rapientrega.presentation.presenters.activities

import com.simplex.rapientrega.domain.interfaces.MapsInterface
import com.simplex.rapientrega.domain.model.activities.MapsModel

class MapsPresenter(private val view: MapsInterface.View) : MapsInterface.Presenter {
    private val model: MapsInterface.Model = MapsModel(this)

    init {
        view.initialObjects()
        view.initialElements()
    }
}