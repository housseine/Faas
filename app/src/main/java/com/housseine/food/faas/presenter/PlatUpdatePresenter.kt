package com.housseine.food.faas.presenter

import com.housseine.food.faas.contract.PlatContract
import com.housseine.food.faas.contract.UpdatePlatContract
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.interactor.PlatInteractor

class PlatUpdatePresenter(private var view: UpdatePlatContract.view) : UpdatePlatContract.Presenter {
    var interactor: PlatContract.Interactor = PlatInteractor()
    override fun onSaveDetailButtonClicked(plat: Plat) {
        interactor.patchPlat(plat)
        view.finishActivity()
    }
    override fun onvViewCreated(plat: Plat) {
        view?.showPlatData(plat)
    }

}