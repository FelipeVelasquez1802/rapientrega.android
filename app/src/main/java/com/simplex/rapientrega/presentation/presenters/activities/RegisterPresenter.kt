package com.simplex.rapientrega.presentation.presenters.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.RegisterEntity
import com.simplex.rapientrega.domain.interfaces.RegisterInterface
import com.simplex.rapientrega.domain.model.activities.RegisterModel
import com.simplex.rapientrega.domain.tools.ERROR_LOGIN
import com.simplex.rapientrega.domain.tools.ERROR_REGISTER
import com.simplex.rapientrega.domain.tools.FIELD_NOT_EMPTY
import com.simplex.rapientrega.domain.tools.SUCCESS_REGISTER_USER

class RegisterPresenter(private val view: RegisterInterface.View) : RegisterInterface.Presenter {

    private val model: RegisterInterface.Model = RegisterModel(this)

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
        if (username.isEmpty()) view.errorUsername(FIELD_NOT_EMPTY)
        else {
            view.errorUsername(null)
            flag++
        }
        if (email.isEmpty()) view.errorEmail(FIELD_NOT_EMPTY)
        else {
            view.errorEmail(null)
            flag++
        }
        if (password.isEmpty()) view.errorPassword(FIELD_NOT_EMPTY)
        else {
            view.errorPassword(null)
            flag++
        }
        if (passwordRepeat.isEmpty()) view.errorPasswordRepeat(FIELD_NOT_EMPTY)
        else {
            view.errorPasswordRepeat(null)
            flag++
        }
        if (identificationCard.isEmpty()) view.errorIdentificationCard(FIELD_NOT_EMPTY)
        else {
            view.errorIdentificationCard(null)
            flag++
        }
        if (cellphone.isEmpty()) view.errorCellphone(FIELD_NOT_EMPTY)
        else {
            view.errorCellphone(null)
            flag++
        }
        if (flag == 6) {
            val registerEntity = RegisterEntity(
                username, email, password, passwordRepeat, identificationCard, cellphone
            )
            model.registerUser(registerEntity)
        } else view.hideProgressBar()
    }

    override fun errorUsername(string: String?) {
        view.errorUsername(string)
    }

    override fun errorEmail(string: String?) {
        view.errorEmail(string)
    }

    override fun errorPassword(string: String?) {
        view.errorPassword(string)
    }

    override fun errorPasswordRepeat(string: String?) {
        view.errorPasswordRepeat(string)
    }

    override fun errorIdentificationCard(string: String?) {
        view.errorIdentificationCard(string)
    }

    override fun errorCellphone(string: String?) {
        view.errorCellphone(string)
    }

    override fun goLoginActivity() {
        view.hideProgressBar()
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