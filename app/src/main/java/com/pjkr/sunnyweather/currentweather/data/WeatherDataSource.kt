package com.pjkr.sunnyweather.currentweather.data

import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.currentweather.model.WeatherResponse
import retrofit2.Callback

/**
 * Created by yabol on 24.07.2017.
 */
interface WeatherDataSource{
    fun getCurrentWeather(cityName: String, callback: OnDataCollectedCallback<Weather>)
    fun getNextFiveDaysWeather(cityName: String, callback: OnDataCollectedCallback<List<Weather>>)
    fun saveWeather(weather: Weather)

    interface OnDataCollectedCallback<T>{
        fun onSuccess(resultObject: T)
        fun onFail(message: String)
    }
}