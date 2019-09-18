package com.housseine.food.faas.contract

import com.housseine.food.faas.entity.Plat

interface DetailPlatContract {
    interface view {
        fun showPlatData (plat: Plat)
    }

    interface Presenter{
        fun onvViewCreated(plat: Plat)
    }

    interface interactor{}

}