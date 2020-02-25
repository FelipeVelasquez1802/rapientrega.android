package com.simplex.rapientrega.presenters.fragments

import com.simplex.rapientrega.interfaces.ProviderInterface
import com.simplex.rapientrega.model.fragments.ProviderModel
import com.simplex.rapientrega.objects.Provider

class ProviderPresenter(private val view: ProviderInterface.View) : ProviderInterface.Presenter {
    private val model: ProviderInterface.Model = ProviderModel(this)
    override fun showProviders(providers: List<Provider>) {
        view.showProviders(providers)
    }

    override fun consultProviders() {
        model.consultProviders()
    }
}