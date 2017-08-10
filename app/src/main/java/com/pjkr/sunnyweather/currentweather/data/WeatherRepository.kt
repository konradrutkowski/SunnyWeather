package com.pjkr.sunnyweather.currentweather.data

import com.pjkr.sunnyweather.currentweather.data.local.WeatherLocalSource
import com.pjkr.sunnyweather.currentweather.data.remote.WeatherRemoteSource
import com.pjkr.sunnyweather.currentweather.model.Weather

/**
 * Created by yabol on 24.07.2017.
 */
class WeatherRepository: WeatherDataSource{

    override fun getCurrentWeather(cityName: String, callback: WeatherDataSource.OnDataCollectedCallback<Weather>) {
        WeatherRemoteSource.getCurrentWeather(cityName, object : WeatherDataSource.OnDataCollectedCallback<Weather>{

            override fun onSuccess(resultObject: Weather) {
                WeatherLocalSource.saveWeather(resultObject)
                callback.onSuccess(resultObject)
            }

            override fun onFail(message: String) {
                callback.onFail(message)
            }

        })
    }

    override fun getNextFiveDaysWeather(cityName: String, callback: WeatherDataSource.OnDataCollectedCallback<List<Weather>>) {

    }

    override fun saveWeather(weather: Weather) {
        WeatherLocalSource.saveWeather(weather)
    }



}