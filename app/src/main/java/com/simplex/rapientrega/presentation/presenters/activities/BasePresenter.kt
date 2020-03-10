package com.simplex.rapientrega.presentation.presenters.activities

import com.simplex.rapientrega.domain.interfaces.BaseInterface
import com.simplex.rapientrega.domain.model.activities.BaseModel

class BasePresenter(private val view: BaseInterface.View) : BaseInterface.Presenter {

    private val model: BaseInterface.Model = BaseModel(this)
    override fun showDialogExit() {
        view.showDialogExit()
    }

    override fun hideDialogExist() {
        view.hideDialogExist()
    }
}