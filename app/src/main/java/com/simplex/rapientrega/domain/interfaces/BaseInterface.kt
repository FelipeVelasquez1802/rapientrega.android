package com.simplex.rapientrega.domain.interfaces

interface BaseInterface {
    interface View {
        fun createDialogExit()
        fun showDialogExit()
        fun hideDialogExist()
    }

    interface Presenter {
        fun showDialogExit()
        fun hideDialogExist()
    }

    interface Model {

    }
}