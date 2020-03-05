package com.simplex.rapientrega.model.activities

import android.util.Log
import com.simplex.rapientrega.R
import com.simplex.rapientrega.api.RepositoryImpl
import com.simplex.rapientrega.api.entities.ProfileEntity
import com.simplex.rapientrega.api.entities.RegisterEntity
import com.simplex.rapientrega.interfaces.RegisterInterface
import com.simplex.rapientrega.tools.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterModel(private val presenter: RegisterInterface.Presenter) :
    RegisterInterface.Model, Callback<ProfileEntity> {

    private val validationFields = ValidationFields()
    private val repository: RepositoryImpl = RepositoryImpl()

    override fun registerUser(registerEntity: RegisterEntity) {
//        var flag = 0
//        if (username.isEmpty()) presenter.showErrorUsername(R.string.not_empty)
//        else {
//            presenter.hideErrorUsername()
//            flag++
//        }
//        if (email.isEmpty()) presenter.showErrorEmail(R.string.not_empty)
//        else {
//            if (validationFields.isEmail(email)) {
//                presenter.hideErrorEmail()
//                flag++
//            } else presenter.showErrorEmail(R.string.not_email)
//        }
//        if (password.isEmpty()) presenter.showErrorPassword(R.string.not_empty)
//        else {
//            presenter.hideErrorPassword()
//            flag++
//        }
//        if (passwordRepeat.isEmpty()) presenter.showErrorPasswordRepeat(R.string.not_empty)
//        else {
//            presenter.hideErrorPasswordRepeat()
//            flag++
//        }
//        if (flag == 4) {

        repository.service().signup(registerEntity).enqueue(this)
    }

    override fun onFailure(call: Call<ProfileEntity>, t: Throwable) {
        Log.d("ErrorRegister", "${t.message}")
        presenter.showErrorMessage(ERROR)
    }

    override fun onResponse(call: Call<ProfileEntity>, response: Response<ProfileEntity>) {
        Log.d("ErrorRegister", "$response")
        if (response.isSuccessful) {
            presenter.goLoginActivity()
        } else {
            when (response.code()) {
                404 -> presenter.showErrorMessage(NOT_FOUND)
                500 -> presenter.showErrorMessage(SERVER_BROKEN)
                else -> presenter.showErrorMessage(ERROR_REGISTER)
            }
        }
    }

}