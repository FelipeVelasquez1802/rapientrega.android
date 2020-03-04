package com.simplex.rapientrega.presenters.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.RegisterInterface
import com.simplex.rapientrega.model.activities.RegisterModel
import com.simplex.rapientrega.tools.ERROR_LOGIN

class RegisterPresenter(private val view: RegisterInterface.View) : RegisterInterface.Presenter {

    private val model: RegisterInterface.Model = RegisterModel(this)

    override fun showErrorUsername(id: Int) {
        view.showErrorUsername(id)
    }

    override fun hideErrorUsername() {
        view.hideErrorUsername()
    }

    override fun showErrorEmail(id: Int) {
        view.showErrorEmail(id)
    }

    override fun hideErrorEmail() {
        view.hideErrorEmail()
    }

    override fun showErrorPassword(id: Int) {
        view.showErrorPassword(id)
    }

    override fun hideErrorPassword() {
        view.hideErrorPassword()
    }

    override fun showErrorPasswordRepeat(id: Int) {
        view.showErrorPasswordRepeat(id)
    }

    override fun hideErrorPasswordRepeat() {
        view.hideErrorPasswordRepeat()
    }

    override fun validateFields(
        username: String,
        email: String,
        password: String,
        passwordRepeat: String,
        identificationCard: String,
        cellphone: String
    ) {
        model.validateFields(
            username,
            email,
            password,
            passwordRepeat,
            identificationCard,
            cellphone
        )
    }

    override fun goLoginActivity() {
        view.goLoginActivity()
    }

    override fun showErrorMessage(id: String) {
        view.showErrorMessage(
            when (id) {
                ERROR_LOGIN -> R.string.error_login
                else -> R.string.error
            }
        )
    }

}