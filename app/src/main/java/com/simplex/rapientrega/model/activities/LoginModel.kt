package com.simplex.rapientrega.model.activities

import android.util.Log
import com.simplex.rapientrega.R
import com.simplex.rapientrega.api.RepositoryImpl
import com.simplex.rapientrega.api.responses.LoginResponse
import com.simplex.rapientrega.interfaces.LoginInterface
import com.simplex.rapientrega.tools.ValidationFields
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginModel(private val presenter: LoginInterface.Presenter) : LoginInterface.Model {

    private val validationFields = ValidationFields()
    private val repository: RepositoryImpl = RepositoryImpl()

    override fun validateLogin(email: String, password: String) {
        presenter.showProgressBar()
//            presenter.goMainActivity()
        repository.service().login(email, password)
            .enqueue(object : retrofit2.Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse: LoginResponse? = response.body()
                    Log.d("Message1", loginResponse.toString())

//                    presenter.hideProgressbar()
//                    presenter.goMainActivity()
                }
            })
    }
}