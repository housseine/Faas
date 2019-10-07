package com.housseine.food.faas.presenter

import com.housseine.food.faas.contract.AddPlatContract
import com.housseine.food.faas.contract.PlatContract
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.interactor.PlatInteractor

class PlatAddPresenter (val view: AddPlatContract.view):AddPlatContract.Presenter{
    var interactor: PlatContract.Interactor = PlatInteractor()
    override fun onSaveDetailButtonClicked(plat: Plat) {
        interactor.addPlat(plat)
        view.finishActivity()
    }
}