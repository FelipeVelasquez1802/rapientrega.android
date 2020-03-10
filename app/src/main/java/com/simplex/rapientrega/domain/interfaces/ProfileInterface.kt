package com.simplex.rapientrega.domain.interfaces

import com.simplex.rapientrega.data.api.entities.ProfileEntity

interface ProfileInterface {
    interface View {
        fun putData(profileEntity: ProfileEntity)
        fun logout(id: String)
        fun goLoginActivity()
    }

    interface Presenter {
        fun putData(profileEntity: ProfileEntity)
        fun convertString(string: String?)
    }

    interface Model {
        fun convertString(string: String)
    }
}