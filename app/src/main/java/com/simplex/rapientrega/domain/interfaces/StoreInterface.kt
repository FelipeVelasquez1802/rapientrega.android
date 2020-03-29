package com.simplex.rapientrega.domain.interfaces

interface StoreInterface {
    interface View {
        fun initialObjects()
        fun initialElements()
        fun showListEmpty()
    }

    interface Presenter {
        fun initial()
    }

    interface Model {
    }
}