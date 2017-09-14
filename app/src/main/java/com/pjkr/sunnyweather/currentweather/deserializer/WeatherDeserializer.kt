package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.currentweather.model.Weather

/**
 * Created by yabol on 14.09.2017.
 */
class WeatherDeserializer : Deserializer<List<Weather>?>{
    companion object {
        private const val MAIN = "main"
        private const val DESCRIPTION = "description"
        private const val ICON = "icon"
    }
    override fun parse(element: JsonElement?): List<Weather>? {
        if(element!!.isJsonArray){
            val jsonObject = element.asJsonArray.get(0).asJsonObject
            val weather = Weather()
            weather.main = jsonObject.get(MAIN).asString
            weather.description = jsonObject.get(DESCRIPTION).asString
            weather.mainIcon = jsonObject.get(ICON).asString

            val result = ArrayList<Weather>()
            result.add(weather)
            return result
        }
        return null
    }

}