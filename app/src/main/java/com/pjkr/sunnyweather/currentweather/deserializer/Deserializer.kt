package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.currentweather.model.Weather

/**
 * Created by yabol on 28.08.2017.
 */
interface Deserializer<T> {
    fun parse(element: JsonElement?): T

}