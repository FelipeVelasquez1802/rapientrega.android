package com.simplex.rapientrega.presenters.activities

import com.simplex.rapientrega.interfaces.LoginInterface
import com.simplex.rapientrega.model.activities.LoginModel

class LoginPresenter(private val view: LoginInterface.View) : LoginInterface.Presenter {

    private var model: LoginInterface.Model = LoginModel(this)

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

    override fun validateFields(email: String, password: String) {
        model.validateFields(email, password)
    }

    override fun goMainActivity() {
        view.goMainActivity()
    }

    override fun goRestorePasswordActivity() {
        view.goRestorePasswordActivity()
    }

    override fun goRegisterActivity() {
        view.goRegisterActivity()
    }

    override fun showProgressBar() {
        view.showProgressBar()
    }

    override fun hideProgressbar() {
        view.hideProgressBar()
    }

}