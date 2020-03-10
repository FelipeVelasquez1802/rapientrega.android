package com.simplex.rapientrega.presentation.presenters.activities

import android.content.SharedPreferences
import com.simplex.rapientrega.R
import com.simplex.rapientrega.data.api.entities.LoginEntity
import com.simplex.rapientrega.domain.interfaces.LoginInterface
import com.simplex.rapientrega.domain.model.activities.LoginModel
import com.simplex.rapientrega.domain.tools.ERROR_LOGIN
import com.simplex.rapientrega.domain.tools.USER

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

    override fun validateLogin(email: String, password: String) {
        var count = 0
        if (email.isEmpty()) {
            view.showErrorEmail(R.string.not_empty)
        } else {
            count++
        }
        if (password.isEmpty()) {
            view.showErrorPassword(R.string.not_empty)
        } else {
            count++
        }
        if (count == 2) model.validateLogin(email, password)
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

    override fun showAlertMessage(id: String) {
        view.showAlertMessage(
            when (id) {
                ERROR_LOGIN -> R.string.error_login
                else -> R.string.error
            }
        )
    }

    override fun isLoginNow(preferences: SharedPreferences) {
        val value = preferences.getString(USER, null)
        if (value != null) {
            view.goMainActivity()
        }
    }

    override fun saveUser(loginEntity: LoginEntity) {
        view.saveUser(USER, loginEntity)
    }

    override fun showDialogExit() {
        view.showDialogExit()
    }

    override fun hideDialogExit() {
        view.hideDialogExit()
    }

}