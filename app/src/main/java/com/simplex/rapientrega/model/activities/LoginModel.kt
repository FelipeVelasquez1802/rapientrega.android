package com.simplex.rapientrega.model.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.LoginInterface

class LoginModel(private val presenter: LoginInterface.Presenter) : LoginInterface.Model {

    private val EMAIL_REGEX =
        "^[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\$"

    override fun validateFields(email: String, password: String) {
        presenter.showProgressBar()
        var flag = 0
        if (email.isEmpty()) {
            presenter.showErrorEmail(R.string.not_empty)
        } else {
            if (isEmail(email)) {
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

    private fun isEmail(email: String): Boolean {
        return !EMAIL_REGEX.toRegex().matches(email)
    }
}