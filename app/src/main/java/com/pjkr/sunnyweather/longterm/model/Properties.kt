package com.pjkr.sunnyweather.longterm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.pjkr.sunnyweather.currentweather.model.Weather

class Properties {

    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("temp")
    @Expose
    var temp: Temp? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Double? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null
    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null
    @SerializedName("speed")
    @Expose
    var speed: Double? = null
    @SerializedName("deg")
    @Expose
    var deg: Int? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Int? = null
    @SerializedName("rain")
    @Expose
    var rain: Double? = null
    @SerializedName("snow")
    @Expose
    var snow: Double? = null
    var dayOfTheWeek: WeatherDay? = null
    var day: String? = null

    var icon: WeatherIcon? = null

    override fun toString(): String {
        return "Properties(dt=$dt, temp=$temp, pressure=$pressure, humidity=$humidity, weather=$weather, speed=$speed, deg=$deg, clouds=$clouds, rain=$rain, snow=$snow, dayOfTheWeek=$dayOfTheWeek, day=$day, icon=$icon)"
    }

}
