package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.longterm.model.Properties

/**
 * Created by yabol on 28.08.2017.
 */
class WeathersListDeserializer: Deserializer<List<Properties>> {
    private var result: List<Properties>? = null
    override fun parse(element: JsonElement) {
        if(element.isJsonArray) {
            var jsonList = element.asJsonArray
            for(element in jsonList){

            }
        }
    }

    override fun getResult(): List<Properties>? {
        return result
    }
}