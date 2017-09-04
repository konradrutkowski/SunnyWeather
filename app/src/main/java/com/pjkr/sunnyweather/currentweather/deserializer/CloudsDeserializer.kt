package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement

/**
 * Created by yabol on 28.08.2017.
 */
class CloudsDeserializer: Deserializer<Int?> {
    companion object {
        const val CLOUDS_VALUE = "all"
    }
    override fun parse(element: JsonElement?): Int? {

        if(element!!.isJsonObject){
            return element.asJsonObject.get(CLOUDS_VALUE).asInt
        }
        return null

    }


}