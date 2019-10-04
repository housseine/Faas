package com.housseine.food.faas.contract

import com.housseine.food.faas.entity.Plat

interface UpdatePlatContract {

    interface view {
        fun showPlatData(plat: Plat)
        fun finishActivity()
    }
    interface Presenter {
        fun onSaveDetailButtonClicked(plat: Plat)
        fun onvViewCreated(plat: Plat)
    }



}