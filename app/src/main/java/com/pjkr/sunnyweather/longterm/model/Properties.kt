package com.pjkr.sunnyweather.longterm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.pjkr.sunnyweather.currentweather.model.Weather
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Ignore

open class Properties: RealmObject() {

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
    var weather: RealmList<Weather>? = null
    @SerializedName("speed")
    @Expose
    var speed: Float? = null
    @SerializedName("deg")
    @Expose
    var deg: Float? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Int? = null
    @SerializedName("rain")
    @Expose
    var rain: Double? = null
    @SerializedName("snow")
    @Expose
    var snow: Double? = null
    @Ignore
    var dayOfTheWeek: WeatherDay? = null
    var timeString: String? = null

    @Ignore
    var icon: WeatherIcon? = null

    override fun toString(): String {
        return "Properties(dt=$dt, temp=$temp, pressure=$pressure, humidity=$humidity, weather=$weather, speed=$speed, deg=$deg, clouds=$clouds, rain=$rain, snow=$snow, dayOfTheWeek=$dayOfTheWeek, timeString=$timeString, mainIcon=$icon)"
    }

}
