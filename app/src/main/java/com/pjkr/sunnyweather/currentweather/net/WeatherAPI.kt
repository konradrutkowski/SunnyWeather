package com.pjkr.sunnyweather.currentweather.net

import com.pjkr.sunnyweather.BuildConfig
import com.pjkr.sunnyweather.currentweather.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

/**
 * Created by PJablonski on 27.06.2017.
 */
interface WeatherAPI {
    @GET("weather?")
    fun getCurrentWeather(@Query("q")cityId: String, @Query("appid")apiKey: String): Call<WeatherResponse>
}