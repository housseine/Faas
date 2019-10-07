package com.housseine.food.faas.contract

import com.housseine.food.faas.entity.Plat

interface AddPlatContract {

    interface view {
        fun finishActivity()
    }

    interface Presenter {
        fun onSaveDetailButtonClicked(plat: Plat)
    }
}