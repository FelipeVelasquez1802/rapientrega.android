package com.simplex.rapientrega.domain.model.fragments

import com.simplex.rapientrega.domain.interfaces.ProfileInterface
import com.simplex.rapientrega.domain.tools.toLoginEntity

class ProfileModel(private val presenter: ProfileInterface.Presenter) : ProfileInterface.Model {
    override fun convertString(string: String) {
        val login = toLoginEntity(string)
        presenter.putData(login.profile)
    }
}