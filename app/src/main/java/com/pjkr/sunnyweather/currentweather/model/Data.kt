package com.pjkr.sunnyweather.currentweather.model

import com.google.gson.annotations.SerializedName

/**
 * Created by PJablonski on 28.06.2017.
 */
class Data (val temp: Double,
            val pressure: Int?,
            val humidity: Int?){
    @SerializedName("temp_min")
    var minTemp: Double? = null
    @SerializedName("temp_max")
    var maxTemp: Double? = null
}