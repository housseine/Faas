package com.housseine.food.faas.entity

import java.io.Serializable

data class Plat (val id: Int, val name:String, val price:Double, val description: String):Serializable{
}