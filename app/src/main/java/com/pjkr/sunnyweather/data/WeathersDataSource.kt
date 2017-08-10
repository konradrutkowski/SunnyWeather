package com.pjkr.sunnyweather.data


import com.pjkr.sunnyweather.currentweather.model.Weather

/**
 * Created by konradrutkowski on 04.07.2017.
 */

interface WeathersDataSource {

    fun getWeatherList(city: String, numberOfDays: String, loadWeathersCallback: LoadWeathersCallback)

    fun getActivatedWeathers(loadWeathersCallback: LoadWeathersCallback)

    fun getDeclinedWeathers(loadWeathersCallback: LoadWeathersCallback)

    fun getWeather(city:String, getWeatherCallback: GetWeatherCallback)


    interface LoadWeathersCallback {

        fun onSuccess(weatherList: List<Weather>)

        fun onFail()
    }

    interface GetWeatherCallback {

        fun onSuccess(weather: Weather)

        fun onFail()
    }

}
