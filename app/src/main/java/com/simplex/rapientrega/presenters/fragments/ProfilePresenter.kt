package com.simplex.rapientrega.presenters.fragments

import com.simplex.rapientrega.api.entities.ProfileEntity
import com.simplex.rapientrega.interfaces.ProfileInterface
import com.simplex.rapientrega.model.fragments.ProfileModel
import com.simplex.rapientrega.tools.USER

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