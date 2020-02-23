package com.simplex.rapientrega.model.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.interfaces.RestorePasswordInterface
import com.simplex.rapientrega.tools.ValidationFields

class RestorePasswordModel(private val presenter: RestorePasswordInterface.Presenter) :
    RestorePasswordInterface.Model {

    private val validationFields = ValidationFields()

    override fun validateFields(email: String) {
        var flag = 0
        if (email.isEmpty()) presenter.showErrorEmail(R.string.not_empty)
        else {
            if (validationFields.isEmail(email)) {
                presenter.hideErrorEmail()
                flag++
            } else presenter.showErrorEmail(R.string.not_email)
        }
        if (flag == 1) presenter.goLoginActivity()
    }

}