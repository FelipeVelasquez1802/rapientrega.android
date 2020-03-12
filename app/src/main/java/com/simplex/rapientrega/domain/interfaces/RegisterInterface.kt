package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.RegisterEntity

interface RegisterInterface {
    interface View {
        fun errorUsername(string: String?)
        fun errorEmail(string: String?)
        fun errorPassword(string: String?)
        fun errorPasswordRepeat(string: String?)
        fun errorIdentificationCard(string: String?)
        fun errorCellphone(string: String?)
        fun goLoginActivity()
        fun showErrorMessage(id: Int)
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface Presenter {
        fun registerUser(
            username: String,
            email: String,
            password: String,
            passwordRepeat: String,
            identificationCard: String,
            cellphone: String
        )

        fun errorUsername(string: String?)
        fun errorEmail(string: String?)
        fun errorPassword(string: String?)
        fun errorPasswordRepeat(string: String?)
        fun errorIdentificationCard(string: String?)
        fun errorCellphone(string: String?)
        fun goLoginActivity()
        fun showErrorMessage(id: String)
    }

    interface Model {
        fun registerUser(registerEntity: RegisterEntity)
    }
}