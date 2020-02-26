package com.simplex.rapientrega.model.activities

import com.simplex.rapientrega.R
import com.simplex.rapientrega.api.RepositoryImpl
import com.simplex.rapientrega.interfaces.LoginInterface
import com.simplex.rapientrega.tools.ValidationFields

class LoginModel(private val presenter: LoginInterface.Presenter) : LoginInterface.Model {

    private val validationFields = ValidationFields()
    private val repository: RepositoryImpl = RepositoryImpl()

    override fun validateLogin(email: String, password: String) {
        presenter.showProgressBar()
//            presenter.goMainActivity()
        repository.service().login(email, password)
    }
}