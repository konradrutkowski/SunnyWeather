package com.pjkr.sunnyweather.currentweather.model

/**
 * Created by PJablonski on 28.06.2017.
 */
class Weather(val id: String, val main: String = "", val description: String = "", val icon: String = "") {
    var coord: Coordinates? = null
    val base: String? = null
    var data: Data? = null
    var visibility: Int? = null
    var wind: Wind? = null
}