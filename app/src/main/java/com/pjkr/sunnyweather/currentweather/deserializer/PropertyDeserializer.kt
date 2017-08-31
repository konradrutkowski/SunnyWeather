package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.currentweather.model.Data
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.longterm.model.Temp
import com.pjkr.sunnyweather.utils.celsiusFromKelvin
import com.pjkr.sunnyweather.utils.extractTimeFromDateTime
import com.pjkr.sunnyweather.utils.fromString
import com.pjkr.sunnyweather.utils.getWeatherDay
import java.util.*

/**
 * Created by yabol on 28.08.2017.
 */
class PropertyDeserializer: Deserializer<Properties?>{
    companion object {
        const val DATA = "main"
        const val CLOUDS = "clouds"
        const val DATE_TIME = "dt_txt"
    }

    private var result: Properties? = null

    override fun parse(element: JsonElement?): Properties? {
        if(element!!.isJsonObject){
            var jsonObject = element.asJsonObject
            result = Properties()
            var dataDEserializer = DataDeserializer()
            val data = dataDEserializer.parse(jsonObject.get(DATA))
            result?.temp = getTemp(data)
            result?.humidity = data?.humidity
            result?.pressure = data?.pressure?.toDouble()
            result?.clouds = CloudsDeserializer().parse(jsonObject.get(CLOUDS))
            setTimeAndDate(result, jsonObject.get(DATE_TIME).asString)

            return result
        }
        return null
    }

    private fun setTimeAndDate(property: Properties?, timeString: String){
        property?.timeString = timeString.extractTimeFromDateTime()
        var calendar = Calendar.getInstance()
        calendar.fromString(timeString)
        property?.dayOfTheWeek = calendar.time.getWeatherDay()
    }

    private fun getTemp(tempData: Data?): Temp{
        var temp = Temp()
        temp.day = tempData?.temp?.celsiusFromKelvin()
        temp.max = tempData?.maxTemp?.celsiusFromKelvin()
        temp.min = tempData?.minTemp?.celsiusFromKelvin()
        return temp

    }

}