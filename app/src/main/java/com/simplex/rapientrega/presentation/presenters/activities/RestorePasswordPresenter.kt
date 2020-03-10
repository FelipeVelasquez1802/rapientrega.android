package com.simplex.rapientrega.presentation.presenters.activities

import com.simplex.rapientrega.domain.interfaces.RestorePasswordInterface
import com.simplex.rapientrega.domain.model.activities.RestorePasswordModel

class RestorePasswordPresenter(private val view: RestorePasswordInterface.View) :
    RestorePasswordInterface.Presenter {

    private val model: RestorePasswordInterface.Model = RestorePasswordModel(this)

    override fun showErrorEmail(id: Int) {
        view.showErrorEmail(id)
    }

    override fun hideErrorEmail() {
        view.hideErrorEmail()
    }

    override fun goLoginActivity() {
        view.goLoginActivity()
    }

    override fun validateFields(email: String) {
        model.validateFields(email)
    }

}