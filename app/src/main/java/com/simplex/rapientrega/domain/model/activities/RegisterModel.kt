package com.simplex.rapientrega.domain.model.activities

import android.util.Log
import com.simplex.rapientrega.data.api.entities.ProfileEntity
import com.simplex.rapientrega.data.api.entities.RegisterEntity
import com.simplex.rapientrega.data.api.repositories.RepositoryImpl
import com.simplex.rapientrega.domain.interfaces.RegisterInterface
import com.simplex.rapientrega.domain.tools.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterModel(private val presenter: RegisterInterface.Presenter) :
    RegisterInterface.Model, Callback<ProfileEntity> {

    private val validationFields = ValidationFields()
    private val repository: RepositoryImpl =
        RepositoryImpl()

    override fun registerUser(registerEntity: RegisterEntity) {
        if (!validationFields.isEmail(registerEntity.email)) {
            presenter.errorEmail(NOT_EMAIL)
        } else {
            presenter.errorEmail(null)
            repository.service().signup(registerEntity).enqueue(this)
        }
    }

    override fun onFailure(call: Call<ProfileEntity>, t: Throwable) {
        Log.d("ErrorRegister", "${t.message}")
        presenter.showErrorMessage(ERROR)
    }

    override fun onResponse(call: Call<ProfileEntity>, response: Response<ProfileEntity>) {
        if (response.isSuccessful) {
            presenter.showErrorMessage(SUCCESS_REGISTER_USER)
            presenter.goLoginActivity()
        } else {
            when (response.code()) {
                400 -> {
                    val errorBody = response.errorBody()?.string()
                    val registerError = toRegisterError(errorBody)
                    if (registerError != null) {
                        presenter.errorUsername(registerError.stringUsername())
                        presenter.errorEmail(registerError.stringEmail())
                        presenter.errorPassword(registerError.stringPassword())
                        presenter.errorPasswordRepeat(registerError.stringPasswordRepeat())
                        presenter.errorIdentificationCard(registerError.stringIdentificationCard())
                        presenter.errorCellphone(registerError.stringCellphone())
                    }
                    presenter.showErrorMessage(ERROR)
                }
                404 -> presenter.showErrorMessage(NOT_FOUND)
                500 -> presenter.showErrorMessage(SERVER_BROKEN)
                else -> presenter.showErrorMessage(ERROR_REGISTER)
            }
        }
    }


}