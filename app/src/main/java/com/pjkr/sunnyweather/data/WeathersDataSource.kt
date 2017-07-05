package com.pjkr.sunnyweather.data


import com.pjkr.sunnyweather.longterm.model.Weather

/**
 * Created by konradrutkowski on 04.07.2017.
 */

interface WeathersDataSource {

    fun getWeatherList(loadWeathersCallback: LoadWeathersCallback)

    fun getActivatedWeathers(loadWeathersCallback: LoadWeathersCallback)

    fun getDeclinedWeathers(loadWeathersCallback: LoadWeathersCallback)

    fun getWeather(getWeatherCallback: GetWeatherCallback): Weather


    interface LoadWeathersCallback {

        fun onSuccess(weatherList: List<Weather>)

        fun onFail()
    }

    interface GetWeatherCallback {

        fun onSuccess(Weathers: Weather)

        fun onFail()
    }

}
