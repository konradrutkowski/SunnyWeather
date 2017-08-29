package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.longterm.model.Properties

/**
 * Created by yabol on 28.08.2017.
 */
class WeathersListDeserializer: Deserializer<List<Properties>?> {
    override fun parse(element: JsonElement?): List<Properties>? {
        if(element!!.isJsonArray) {
            var list = ArrayList<Properties>()
            var jsonList = element.asJsonArray
            return jsonList.mapTo(list) { PropertyDeserializer().parse(it)!! }
        }
        return null
    }


}