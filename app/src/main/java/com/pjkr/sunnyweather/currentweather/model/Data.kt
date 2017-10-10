package com.pjkr.sunnyweather.currentweather.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

/**
 * Created by PJablonski on 28.06.2017.
 */
open class Data: RealmObject() {
    var temp: Double? = null
    var pressure: Int? = null
    var humidity: Int? = null
    @SerializedName("temp_min")
    var minTemp: Double? = null
    @SerializedName("temp_max")
    var maxTemp: Double? = null
}