package com.housseine.food.faas.contract

import com.housseine.food.faas.entity.Plat

interface PlatContract {
    interface view {
        fun publishDataList(data: List<Plat>)
        fun navigateToDetails(plat: Plat?)
        fun navigateToEdition(plat: Plat?)
    }

    interface Presenter {
        fun onListItemClicked(plat: Plat?)
        fun onEditButtonClicked(plat: Plat?)
        fun onViewCreated()
        fun onQuerySuccess(data: List<Plat>)
    }

    interface Interactor {
        fun loadPlatList(): String?
        fun patchPlat(plat: Plat?)
    }
}