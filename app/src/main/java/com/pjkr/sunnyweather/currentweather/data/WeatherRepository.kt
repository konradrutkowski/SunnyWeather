package com.pjkr.sunnyweather.currentweather.data

import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.currentweather.model.WeatherResponse
import retrofit2.Call
import retrofit2.Response

/**
 * Created by yabol on 24.07.2017.
 */
class WeatherRepository(var remoteDataSource: WeatherDataSource,
                        var localDataSource: WeatherDataSource): WeatherDataSource{

    override fun getCurrentWeather(cityName: String, callback: WeatherDataSource.OnDataCollectedCallback<Weather>) {
        remoteDataSource.getCurrentWeather(cityName, object : WeatherDataSource.OnDataCollectedCallback<Weather>{

            override fun onSuccess(resultObject: Weather) {
                localDataSource.saveWeather(resultObject)
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
        this.localDataSource.saveWeather(weather)
    }



}