package com.pjkr.sunnyweather.data.weather.local


import com.pjkr.sunnyweather.data.weather.WeathersDataSource

/**
 * Created by konradrutkowski on 04.07.2017.
 */

object LocalDataSource : WeathersDataSource {
    override fun getCurrentWeather(cityName: String, callback: WeathersDataSource.GetWeatherCallback) {

    }

    override fun getWeatherList(city: String, numberOfDays: String, loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {}

    override fun getWeather(city: String, getWeatherCallback: WeathersDataSource.GetWeatherCallback) {
    }


}
