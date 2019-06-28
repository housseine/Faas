package com.housseine.food.faas.contract

class SplashContract {

    interface View{
    }

    interface Presenter{
        fun onViewCreated()
        fun onDestroy()
    }

}