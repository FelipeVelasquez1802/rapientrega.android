package com.simplex.rapientrega.interfaces

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
    }

    interface Presenter {
        fun showErrorUsername(id: Int)
        fun hideErrorUsername()
        fun showErrorEmail(id: Int)
        fun hideErrorEmail()
        fun showErrorPassword(id: Int)
        fun hideErrorPassword()
        fun showErrorPasswordRepeat(id: Int)
        fun hideErrorPasswordRepeat()
        fun validateFields(
            username: String,
            email: String,
            password: String,
            passwordRepeat: String
        )

        fun goLoginActivity()
    }

    interface Model {
        fun validateFields(
            username: String,
            email: String,
            password: String,
            passwordRepeat: String
        )
    }
}