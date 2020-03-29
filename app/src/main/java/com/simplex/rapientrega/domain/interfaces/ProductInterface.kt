package com.simplex.rapientrega.domain.interfaces

interface ProductInterface {
    interface View {
        fun initialElements()
        fun initialObjects()
        fun showListEmpty()
    }

    interface Presenter {
        fun initial()
    }

    interface Model {

    }
}