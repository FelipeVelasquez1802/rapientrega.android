package com.simplex.rapientrega.presentation.presenters.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.RegisterEntity
import com.simplex.rapientrega.domain.interfaces.RegisterInterface
import com.simplex.rapientrega.domain.model.activities.RegisterModel
import com.simplex.rapientrega.domain.tools.ERROR_LOGIN
import com.simplex.rapientrega.domain.tools.ERROR_REGISTER
import com.simplex.rapientrega.domain.tools.SUCCESS_REGISTER_USER

class RegisterPresenter(private val view: RegisterInterface.View) : RegisterInterface.Presenter {

    private val model: RegisterInterface.Model = RegisterModel(this)

    override fun showErrorEmail(id: Int) {
        view.showErrorEmail(id)
    }

    override fun hideErrorEmail() {
        view.hideErrorEmail()
    }

    override fun registerUser(
        username: String,
        email: String,
        password: String,
        passwordRepeat: String,
        identificationCard: String,
        cellphone: String
    ) {
        view.showProgressBar()
        var flag = 0
        if (username.isEmpty()) view.showErrorUsername(R.string.not_empty)
        else {
            view.hideErrorUsername()
            flag++
        }
        if (email.isEmpty()) view.showErrorEmail(R.string.not_empty)
        else {
            view.hideErrorEmail()
            flag++
        }
        if (password.isEmpty()) view.showErrorPassword(R.string.not_empty)
        else {
            view.hideErrorPassword()
            flag++
        }
        if (passwordRepeat.isEmpty()) view.showErrorPasswordRepeat(R.string.not_empty)
        else {
            view.hideErrorPasswordRepeat()
            flag++
        }
        if (flag == 4) {
            val registerEntity = RegisterEntity(
                username, email, password, passwordRepeat, identificationCard, cellphone
            )
            model.registerUser(registerEntity)
        }
    }

    override fun goLoginActivity() {
        view.hideErrorEmail()
        view.goLoginActivity()
    }

    override fun showErrorMessage(id: String) {
        view.hideProgressBar()
        view.showErrorMessage(
            when (id) {
                ERROR_LOGIN -> R.string.error_login
                ERROR_REGISTER -> R.string.error_register
                SUCCESS_REGISTER_USER -> R.string.success_register_user
                else -> R.string.error
            }
        )
    }

}