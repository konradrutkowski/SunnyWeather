package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.pjkr.sunnyweather.api.dto.WeatherTodayForecastResponse
import java.lang.reflect.Type

/**
 * Created by yabol on 28.08.2017.
 */
class GsonForecastDeserializer: JsonDeserializer<WeatherTodayForecastResponse> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): WeatherTodayForecastResponse {
        return ForecastDeserializer().parse(json)!!
    }
}