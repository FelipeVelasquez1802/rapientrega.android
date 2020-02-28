package com.simplex.rapientrega.interfaces

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