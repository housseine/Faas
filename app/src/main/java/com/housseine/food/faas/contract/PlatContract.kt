package com.housseine.food.faas.contract

import android.content.Intent
import com.housseine.food.faas.entity.Plat

interface PlatContract{
    interface view {
        fun publishDataList(data: List<Plat>)
        fun navigateTo(plat: Plat?):Intent
    }

    interface Presenter{
        fun listItemClicked(plat: Plat?):Intent
        fun onViewCreated()
        fun onQuerySuccess(data: List<Plat>)
    }

    interface Interactor{
        fun loadPlatList():String?
    }
}