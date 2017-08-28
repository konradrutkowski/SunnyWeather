package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.currentweather.model.Data
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.longterm.model.Temp

/**
 * Created by yabol on 28.08.2017.
 */
class PropertyDeserializer: Deserializer<Properties>{
    private var result: Properties? = null

    override fun parse(element: JsonElement) {
        if(element.isJsonObject){
            var jsonObject = element.asJsonObject
            result = Properties()
            var dataDEserializer = DataDeserializer()
            dataDEserializer.parse(jsonObject.get("main"))
            val data = dataDEserializer.getResult()
            result?.temp = getTemp(data)
            result?.humidity = data?.humidity
            result?.pressure = data?.pressure as Double
        }
    }

    private fun getTemp(tempData: Data?): Temp{
        var temp = Temp()
        temp.day = tempData?.temp
        temp.max = tempData?.maxTemp
        temp.min = tempData?.minTemp
        return temp

    }

    override fun getResult(): Properties? {
        return result
    }

}