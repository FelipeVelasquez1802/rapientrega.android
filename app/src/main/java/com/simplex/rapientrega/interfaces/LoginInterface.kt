package com.simplex.rapientrega.interfaces

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
    }

    interface Presenter {
        fun showErrorEmail(id: Int)
        fun hideErrorEmail()
        fun showErrorPassword(id: Int)
        fun hideErrorPassword()
        fun validateFields(email: String, password: String)
        fun goMainActivity()
        fun goRestorePasswordActivity()
        fun goRegisterActivity()
        fun showProgressBar()
        fun hideProgressbar()
    }

    interface Model {
        fun validateFields(email: String, password: String)
    }
}