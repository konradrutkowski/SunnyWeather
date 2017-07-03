package com.pjkr.sunnyweather.currentweather.model

import com.google.gson.annotations.SerializedName

/**
 * Created by PJablonski on 28.06.2017.
 */
class WeatherResponse(val coord: Coordinates?, val base: String?, val main: Data?, val visibility: Int?, val wind: Wind?) {
    @SerializedName("weather")
    val weathers: List<Weather>? = null
}