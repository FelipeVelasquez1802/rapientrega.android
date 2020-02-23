package com.simplex.rapientrega.interfaces

interface RestorePasswordInterface {
    interface View {
        fun showErrorEmail(id: Int)
        fun hideErrorEmail()
        fun goLoginActivity()
    }

    interface Presenter {
        fun showErrorEmail(id: Int)
        fun hideErrorEmail()
        fun goLoginActivity()
        fun validateFields(email: String)
    }

    interface Model {
        fun validateFields(email: String)
    }
}