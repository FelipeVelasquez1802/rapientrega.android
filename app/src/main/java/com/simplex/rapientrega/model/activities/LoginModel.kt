package com.simplex.rapientrega.model.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.LoginInterface
import com.simplex.rapientrega.tools.ValidationFields

class LoginModel(private val presenter: LoginInterface.Presenter) : LoginInterface.Model {

    private val validationFields = ValidationFields()

    override fun validateFields(email: String, password: String) {
        presenter.showProgressBar()
        var flag = 0
        if (email.isEmpty()) {
            presenter.showErrorEmail(R.string.not_empty)
        } else {
            if (validationFields.isEmail(email)) {
                presenter.showErrorEmail(R.string.not_email)
            } else {
                presenter.hideErrorEmail()
                flag++
            }
        }
        if (password.isEmpty()) {
            presenter.showErrorPassword(R.string.not_empty)
        } else {
            presenter.hideErrorPassword()
            flag++
        }
        presenter.hideProgressbar()
        if (flag == 2) {
            presenter.goMainActivity()
        }
    }
}