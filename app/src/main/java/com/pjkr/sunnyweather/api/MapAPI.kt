package com.pjkr.sunnyweather.api

import com.pjkr.sunnyweather.currentweather.model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by konradrutkowski on 28.06.2017.
 */

interface MapAPI {
    @GET("/data/2.5/forecast/daily")
    fun getWeather(@Query("q") cityName: String,
                   @Query("cnt") numberOfDays: String,
                   @Query("units") unit: String,
                   @Query("APPID") keyApi: String): Call<Weather>
}
