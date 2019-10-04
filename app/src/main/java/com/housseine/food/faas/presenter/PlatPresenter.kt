package com.housseine.food.faas.presenter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.housseine.food.faas.contract.PlatContract
import com.housseine.food.faas.entity.Plat
import com.housseine.food.faas.interactor.PlatInteractor

class PlatPresenter(var view: PlatContract.view) : PlatContract.Presenter {

    private var interactor: PlatContract.Interactor? = PlatInteractor()
    override fun onEditButtonClicked(plat: Plat?) {
        view.navigateToEdition(plat)
    }

    override fun onListItemClicked(plat: Plat?) {
        view.navigateToDetails(plat)
    }
    override fun onViewCreated() {
        var plats = interactor?.loadPlatList()
        val type = object : TypeToken<List<Plat>>() {}.type
        val jokesList: List<Plat> = Gson().fromJson(plats, type)
        onQuerySuccess(jokesList)
    }

        override fun onQuerySuccess(data: List<Plat>) {
        view.publishDataList(data)
    }
}