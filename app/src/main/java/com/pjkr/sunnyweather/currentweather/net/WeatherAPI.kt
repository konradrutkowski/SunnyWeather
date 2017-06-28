package com.pjkr.sunnyweather.currentweather.net

import com.pjkr.sunnyweather.BuildConfig
import com.pjkr.sunnyweather.currentweather.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by PJablonski on 27.06.2017.
 */
interface WeatherAPI {
    @GET("http://samples.openweathermap.org/data/2.5/weather?")
    fun getCurrentWeather(@Query("id")cityId: String, @Query("appid")apiKey: String): WeatherResponse
}