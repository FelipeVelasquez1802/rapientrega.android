package com.simplex.rapientrega.presenters.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.api.entities.RegisterEntity
import com.simplex.rapientrega.interfaces.RegisterInterface
import com.simplex.rapientrega.model.activities.RegisterModel
import com.simplex.rapientrega.tools.ERROR_LOGIN
import com.simplex.rapientrega.tools.ERROR_REGISTER

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

    override fun registerUser(
        username: String,
        email: String,
        password: String,
        passwordRepeat: String,
        identificationCard: String,
        cellphone: String
    ) {
        val registerEntity = RegisterEntity(
            "felipe",
            "admin@gmail.com",
            "admin2345",
            "admin2345",
            "1121922340",
            "305313600"
        )
//        registerEntity.username = username
//        registerEntity.email = email
//        registerEntity.password = password
//        registerEntity.passwordRepeat = passwordRepeat
//        registerEntity.identificationCard = identificationCard
//        registerEntity.cellphone = cellphone
        model.registerUser(registerEntity)
    }

    override fun goLoginActivity() {
        view.goLoginActivity()
    }

    override fun showErrorMessage(id: String) {
        view.showErrorMessage(
            when (id) {
                ERROR_LOGIN -> R.string.error_login
                ERROR_REGISTER -> R.string.error_register
                else -> R.string.error
            }
        )
    }

}