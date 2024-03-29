package com.housseine.food.faas.presenter

import com.housseine.food.faas.contract.DetailPlatContract
import com.housseine.food.faas.contract.PlatContract
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.interactor.PlatInteractor

class PlatDetailsPresenter(private var view: DetailPlatContract.view?) : DetailPlatContract.Presenter {
    var interactor: PlatContract.Interactor = PlatInteractor()
    override fun onvViewCreated(plat: Plat) {
        view?.showPlatData(plat)
    }

}