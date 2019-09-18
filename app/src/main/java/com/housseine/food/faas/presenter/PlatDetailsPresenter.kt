package com.housseine.food.faas.presenter

import com.housseine.food.faas.contract.DetailPlatContract
import com.housseine.food.faas.entity.Plat

class PlatDetailsPresenter(private var view: DetailPlatContract.view?) :DetailPlatContract.Presenter {
    override fun onvViewCreated(plat: Plat) {
        view?.showPlatData(plat)
    }

}