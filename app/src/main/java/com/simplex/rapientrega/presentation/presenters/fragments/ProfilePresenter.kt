package com.simplex.rapientrega.presentation.presenters.fragments

import com.simplex.rapientrega.data.api.entities.ProfileEntity
import com.simplex.rapientrega.domain.interfaces.ProfileInterface
import com.simplex.rapientrega.domain.model.fragments.ProfileModel
import com.simplex.rapientrega.domain.tools.USER

class ProfilePresenter(private val view: ProfileInterface.View) : ProfileInterface.Presenter {

    private val model: ProfileInterface.Model = ProfileModel(this)

    override fun putData(profileEntity: ProfileEntity) {
        view.putData(profileEntity)
    }

    override fun convertString(string: String?) {
        if (string != null) model.convertString(string)
        else {
            view.logout(USER)
            view.goLoginActivity()
        }
    }
}