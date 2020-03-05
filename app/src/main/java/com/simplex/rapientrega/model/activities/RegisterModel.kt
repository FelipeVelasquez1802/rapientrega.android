package com.simplex.rapientrega.model.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.RegisterInterface
import com.simplex.rapientrega.tools.ValidationFields

class RegisterModel(private val presenter: RegisterInterface.Presenter) : RegisterInterface.Model {

    private val validationFields = ValidationFields()

    override fun validateFields(
        username: String,
        email: String,
        password: String,
        passwordRepeat: String
    ) {
        var flag = 0
        if (username.isEmpty()) presenter.showErrorUsername(R.string.not_empty)
        else {
            presenter.hideErrorUsername()
            flag++
        }
        if (email.isEmpty()) presenter.showErrorEmail(R.string.not_empty)
        else {
            if (validationFields.isEmail(email)) {
                presenter.hideErrorEmail()
                flag++
            } else presenter.showErrorEmail(R.string.not_email)
        }
        if (password.isEmpty()) presenter.showErrorPassword(R.string.not_empty)
        else {
            presenter.hideErrorPassword()
            flag++
        }
        if (passwordRepeat.isEmpty()) presenter.showErrorPasswordRepeat(R.string.not_empty)
        else {
            presenter.hideErrorPasswordRepeat()
            flag++
        }
        if (flag == 4) presenter.goLoginActivity()
    }

}