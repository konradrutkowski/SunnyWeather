package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.currentweather.model.Data

/**
 * Created by yabol on 28.08.2017.
 */
class DataDeserializer : Deserializer<Data?> {
    companion object {
        const val TEMP = "temp"
        const val PRESSURE = "pressure"
        const val HUMIDITY = "humidity"
        const val MIN_TEMP = "temp_min"
        const val MAX_TEMP = "temp_max"
    }

    override fun parse(element: JsonElement?): Data? {
        var result : Data?= null
        if(element!!.isJsonObject){
            var dataObject = element.asJsonObject
            val temperature = dataObject.get(TEMP).asDouble
            val pressure = dataObject.get(PRESSURE).asInt
            val humidity = dataObject.get(HUMIDITY).asInt
            result = Data()
            result.temp = temperature
            result.pressure = pressure
            result.humidity = humidity
            result.minTemp = dataObject.get(MIN_TEMP).asDouble
            result.maxTemp = dataObject.get(MAX_TEMP).asDouble
        }
        return result
    }

}