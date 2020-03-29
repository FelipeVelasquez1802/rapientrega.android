package com.simplex.rapientrega.domain.model.activities

import com.simplex.rapientrega.data.api.entities.LoginEntity
import com.simplex.rapientrega.data.api.repositories.RepositoryImpl
import com.simplex.rapientrega.domain.interfaces.LoginInterface
import com.simplex.rapientrega.domain.tools.ERROR
import com.simplex.rapientrega.domain.tools.ERROR_LOGIN
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModel(private val presenter: LoginInterface.Presenter) :
    LoginInterface.Model,
    Callback<LoginEntity> {

    private val repository: RepositoryImpl = RepositoryImpl()

    override fun validateLogin(email: String, password: String) {
        presenter.showProgressBar()
        repository.service().login(email, password)
            .enqueue(this)
    }

    override fun onFailure(call: Call<LoginEntity>, t: Throwable) {
        presenter.showAlertMessage(ERROR)
        presenter.hideProgressbar()
    }

    override fun onResponse(call: Call<LoginEntity>, response: Response<LoginEntity>) {
        presenter.hideProgressbar()
        val loginEntity: LoginEntity? = response.body()
        if (loginEntity != null) {
            presenter.saveUser(loginEntity)
            presenter.goMainActivity()
        } else presenter.showAlertMessage(ERROR_LOGIN)
        presenter.hideProgressbar()
    }
}