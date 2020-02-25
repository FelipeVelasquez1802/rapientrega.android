package com.simplex.rapientrega.model.fragments

import com.simplex.rapientrega.interfaces.ProviderInterface
import com.simplex.rapientrega.tests.ProviderTest

class ProviderModel(private val presenter: ProviderInterface.Presenter) : ProviderInterface.Model {
    override fun consultProviders() {
        presenter.showProviders(ProviderTest().providersList())
    }
}