package com.simplex.rapientrega.interfaces

import com.simplex.rapientrega.objects.Provider

interface ProviderInterface {
    interface View {
        fun showProviders(providers: List<Provider>)
    }

    interface Presenter {
        fun showProviders(providers: List<Provider>)
        fun consultProviders()
    }

    interface Model {
        fun consultProviders()
    }
}