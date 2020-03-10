package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.RegisterEntity

interface RegisterInterface {
    interface View {
        fun showErrorUsername(id: Int)
        fun hideErrorUsername()
        fun showErrorEmail(id: Int)
        fun hideErrorEmail()
        fun showErrorPassword(id: Int)
        fun hideErrorPassword()
        fun showErrorPasswordRepeat(id: Int)
        fun hideErrorPasswordRepeat()
        fun goLoginActivity()
        fun showErrorMessage(id: Int)
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface Presenter {
        fun showErrorEmail(id: Int)
        fun hideErrorEmail()
        fun registerUser(
            username: String,
            email: String,
            password: String,
            passwordRepeat: String,
            identificationCard: String,
            cellphone: String
        )

        fun goLoginActivity()
        fun showErrorMessage(id: String)
    }

    interface Model {
        fun registerUser(registerEntity: RegisterEntity)
    }
}