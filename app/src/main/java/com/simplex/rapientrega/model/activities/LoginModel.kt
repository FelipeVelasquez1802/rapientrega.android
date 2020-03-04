package com.simplex.rapientrega.model.activities

import android.util.Log
import com.simplex.rapientrega.api.RepositoryImpl
import com.simplex.rapientrega.api.entities.LoginEntity
import com.simplex.rapientrega.interfaces.LoginInterface
import com.simplex.rapientrega.tools.ERROR
import com.simplex.rapientrega.tools.ERROR_LOGIN
import com.simplex.rapientrega.tools.ValidationFields
import retrofit2.Call
import retrofit2.Response

class LoginModel(private val presenter: LoginInterface.Presenter) : LoginInterface.Model {

    private val repository: RepositoryImpl = RepositoryImpl()

    override fun validateLogin(email: String, password: String) {
        presenter.showProgressBar()
        repository.service().login(email, password)
            .enqueue(object : retrofit2.Callback<LoginEntity> {
                override fun onFailure(call: Call<LoginEntity>, t: Throwable) {
                    Log.d("ErrorLogin", "${t.message}")
                    presenter.showAlertMessage(ERROR)
                }

                override fun onResponse(
                    call: Call<LoginEntity>, entity: Response<LoginEntity>
                ) {
                    presenter.hideProgressbar()
                    val loginEntity: LoginEntity? = entity.body()
                    if (loginEntity != null) {
                        presenter.saveUser(loginEntity)
                        presenter.goMainActivity()
                    } else presenter.showAlertMessage(ERROR_LOGIN)
                }
            })
    }
}