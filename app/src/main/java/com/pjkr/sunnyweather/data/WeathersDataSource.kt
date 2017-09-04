package com.pjkr.sunnyweather.data


import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.longterm.model.Properties

/**
 * Created by konradrutkowski on 04.07.2017.
 */

public interface WeathersDataSource {

    fun getWeatherList(city: String, numberOfDays: String, loadWeathersCallback: LoadWeathersCallback)

    fun getActivatedWeathers(loadWeathersCallback: LoadWeathersCallback)

    fun getDeclinedWeathers(loadWeathersCallback: LoadWeathersCallback)

    fun getWeather(city:String, getWeatherCallback: GetWeatherCallback)

    fun getCurrentWeather(cityName: String, callback: GetWeatherCallback)

    fun getTodayForecast(cityName: String, callback: LoadWeathersCallback)



    interface LoadWeathersCallback {

        fun onSuccess(weatherList: List<Properties>?)

        fun onFail()
    }

    interface GetWeatherCallback {

        fun onSuccess(weather: Weather)

        fun onFail()
    }

}
