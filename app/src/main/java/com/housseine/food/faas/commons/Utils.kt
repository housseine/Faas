package com.housseine.food.faas.commons

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class Utils {

    companion object {
        fun addFragment(
            fragment: Fragment,
            addToBackStack: Boolean,
            container: Int,
            fragmentManager: FragmentManager,
            tag: String
        ) {
            val ft = fragmentManager.beginTransaction()

            if (addToBackStack) {
                ft.addToBackStack(tag)
            }
            ft.replace(container, fragment, "fragment")
            ft.commitAllowingStateLoss()
        }
    }
}