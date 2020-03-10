package com.simplex.rapientrega.domain.interfaces

interface StoreInterface {
    interface View {
    }

    interface Presenter {
        fun consultProviders()
    }

    interface Model {
        fun consultProviders()
    }
}