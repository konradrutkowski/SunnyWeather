package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.currentweather.model.Wind

/**
 * Created by yabol on 02.09.2017.
 */
class WindDeserialiser : Deserializer<Wind?>{
    private companion object {
        const val SPEED = "speed"
        const val DEGREES = "deg"
    }
    override fun parse(element: JsonElement?): Wind? {
        if(element?.isJsonObject!!){
            val jsonObj = element.asJsonObject
            return Wind(jsonObj.get(SPEED).asFloat,
                    jsonObj.get(DEGREES).asFloat)
        }
        return null;
    }

}