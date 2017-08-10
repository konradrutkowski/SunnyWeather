package com.pjkr.sunnyweather.currentweather.data.local

import com.pjkr.sunnyweather.currentweather.data.WeatherDataSource
import com.pjkr.sunnyweather.currentweather.model.Weather

/**
 * Created by yabol on 24.07.2017.
 */
object WeatherLocalSource : WeatherDataSource {
    override fun saveWeather(weather: Weather) {

    }

    override fun getNextFiveDaysWeather(cityName: String, callback: WeatherDataSource.OnDataCollectedCallback<List<Weather>>) {
    }

    override fun getCurrentWeather(cityName: String, callback: WeatherDataSource.OnDataCollectedCallback<Weather>) {
    }


}