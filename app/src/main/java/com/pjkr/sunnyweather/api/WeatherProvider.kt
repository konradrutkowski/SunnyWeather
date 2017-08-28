package com.pjkr.sunnyweather.api


import com.pjkr.sunnyweather.BuildConfig
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.currentweather.model.WeatherResponse
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by konradrutkowski on 28.06.2017.
 */

class WeatherProvider {

    val BASE_URL = "http://api.openweathermap.org"
    val retrofit: Retrofit
    val mapAPI: MapAPI


    init {
        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        mapAPI = retrofit.create(MapAPI::class.java)
    }

    fun getWeather(city:String, numberOfDays: String, callback: Callback<Weather>) {
        val weatherCall = mapAPI.getWeather(city, numberOfDays, "metric",BuildConfig.WEATHER_API)
        weatherCall.enqueue(callback)
    }

    fun getCurrentWeather(cityId: String, callback: Callback<WeatherResponse>){
        mapAPI.getCurrentWeather(cityId, BuildConfig.WEATHER_API).enqueue(callback)
    }

    fun getTodaysWeatherForecast(cityId: String, callback: Callback<Weather>){
        mapAPI.getTodaysWeatherForecast(cityId, BuildConfig.WEATHER_API).enqueue(callback)
    }

}
