package com.simplex.rapientrega.interfaces

import android.content.SharedPreferences
import com.simplex.rapientrega.api.entities.LoginEntity

interface LoginInterface {
    interface View {
        fun showErrorEmail(id: Int)
        fun hideErrorEmail()
        fun showErrorPassword(id: Int)
        fun hideErrorPassword()
        fun goMainActivity()
        fun goRestorePasswordActivity()
        fun goRegisterActivity()
        fun showProgressBar()
        fun hideProgressBar()
        fun showAlertMessage(id: Int)
        fun saveUser(key: String, any: Any)
    }

    interface Presenter {
        fun showErrorEmail(id: Int)
        fun hideErrorEmail()
        fun showErrorPassword(id: Int)
        fun hideErrorPassword()
        fun validateLogin(email: String, password: String)
        fun goMainActivity()
        fun goRestorePasswordActivity()
        fun goRegisterActivity()
        fun showProgressBar()
        fun hideProgressbar()
        fun showAlertMessage(id: String)
        fun isLoginNow(preferences: SharedPreferences)
        fun saveUser(loginEntity: LoginEntity)
    }

    interface Model {
        fun validateLogin(email: String, password: String)
    }
}