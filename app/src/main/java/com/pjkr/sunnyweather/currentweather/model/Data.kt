package com.pjkr.sunnyweather.currentweather.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

/**
 * Created by PJablonski on 28.06.2017.
 */
open class Data: RealmObject() {
    var temp: Double = 0.00
    var pressure: Int = 0
    var humidity: Int = 0
    @SerializedName("temp_min")
    var minTemp: Double? = 0.00
    @SerializedName("temp_max")
    var maxTemp: Double? = 0.00
}