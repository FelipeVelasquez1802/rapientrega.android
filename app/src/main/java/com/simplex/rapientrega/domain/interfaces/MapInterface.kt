package com.simplex.rapientrega.domain.interfaces

import android.os.Bundle

interface MapInterface {
    interface View {
        fun initialElement(savedInstanceState: Bundle?)
        fun stateProgressBar(id: Int)
        fun addListener()
    }

    interface Presenter {
        fun initial(savedInstanceState: Bundle?)
        fun stateProgressBar(state: Boolean)
    }

    interface Model {

    }
}