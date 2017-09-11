package com.pjkr.sunnyweather.api.dto

import com.google.gson.annotations.SerializedName
import com.pjkr.sunnyweather.currentweather.model.Coordinates
import com.pjkr.sunnyweather.currentweather.model.Data
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.currentweather.model.Wind

/**
 * Created by PJablonski on 28.06.2017.
 */
class WeatherResponse(val coord: Coordinates?, val base: String?, val main: Data?, val visibility: Int?, val wind: Wind?) {
    @SerializedName("weather")
    val weathers: List<Weather>? = null
    val name: String? = null
}