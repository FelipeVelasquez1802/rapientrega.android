package com.simplex.rapientrega.model.fragments

import com.simplex.rapientrega.interfaces.ProfileInterface
import com.simplex.rapientrega.tools.toLoginEntity

class ProfileModel(private val presenter: ProfileInterface.Presenter) : ProfileInterface.Model {
    override fun convertString(string: String) {
        val login = toLoginEntity(string)
        presenter.putData(login.profile)
    }
}