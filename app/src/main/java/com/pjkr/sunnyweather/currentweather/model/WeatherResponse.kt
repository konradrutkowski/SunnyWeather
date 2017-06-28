package com.pjkr.sunnyweather.currentweather.model

/**
 * Created by PJablonski on 28.06.2017.
 */
class WeatherResponse(val coord: Coordinates?, val weathers: List<Weather>?, val base: String?, val main: Data?, val visibility: Int?, val wind: Wind?) {
}