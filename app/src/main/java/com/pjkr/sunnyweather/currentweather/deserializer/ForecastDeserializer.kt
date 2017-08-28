package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.longterm.model.Properties

/**
 * Created by yabol on 28.08.2017.
 */
class ForecastDeserializer : Deserializer<Weather> {
    private var result : Weather? = null
    override fun parse(element: JsonElement) {
        if(element.isJsonObject) {
            var jsonObject = element.asJsonObject;
            jsonObject.get("list");
        }

    }

    override fun getResult(): Weather? {
        return result
    }
}