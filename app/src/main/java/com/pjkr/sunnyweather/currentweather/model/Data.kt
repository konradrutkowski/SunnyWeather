package com.pjkr.sunnyweather.currentweather.model

import com.google.gson.annotations.SerializedName

/**
 * Created by PJablonski on 28.06.2017.
 */
class Data (val temp: Float,
            val pressure: Int?,
            val humidity: Int?){
    @SerializedName("temp_min")
    val minTemp: Float? = null
    @SerializedName("temp_max")
    val maxTemp: Float? = null
}