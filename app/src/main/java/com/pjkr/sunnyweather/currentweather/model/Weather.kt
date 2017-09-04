package com.pjkr.sunnyweather.currentweather.model

import com.pjkr.sunnyweather.longterm.model.City
import com.pjkr.sunnyweather.longterm.model.Properties

/**
 * Created by PJablonski on 28.06.2017.
 */
class Weather(val id: String? = "", val main: String? = "", val description: String? = "", val icon: String? = "") {
    var coord: Coordinates? = null
    val base: String? = null
    var data: Data? = null
    var visibility: Int? = null
    var wind: Wind? = null
    var name: String? = null
    var city: City? = null
    var cod: String? = null
    var message: Double? = null
    var cnt: Int? = null
    var list: List<Properties>? = null
    var clouds: Clouds? = null
}