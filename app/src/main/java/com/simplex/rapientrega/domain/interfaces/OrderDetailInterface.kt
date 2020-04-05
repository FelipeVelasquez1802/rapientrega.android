package com.simplex.rapientrega.domain.interfaces

interface OrderDetailInterface {
    interface View {
        fun initialObjects()
        fun initialElements()
    }

    interface Presenter {
        fun initial()
    }

    interface Model {}
}