package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.currentweather.model.forecast.WeatherTodayForecastResponse

/**
 * Created by yabol on 28.08.2017.
 */
class ForecastDeserializer : Deserializer<WeatherTodayForecastResponse?> {
    companion object {
        const val WEATHERS = "list"
    }
    override fun parse(element: JsonElement?): WeatherTodayForecastResponse? {
        if(element!!.isJsonObject) {
            var weather  = WeatherTodayForecastResponse()
            var jsonObject = element.asJsonObject
            weather.properties = WeathersListDeserializer().parse(jsonObject.get(WEATHERS).asJsonArray)
            return weather
        }
        return null
    }


}