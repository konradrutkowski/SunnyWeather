package com.pjkr.sunnyweather.data

import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.longterm.model.Properties
import io.realm.RealmList

/**
 * Created by konradrutkowski on 04.07.2017.
 */

class WeathersRepository constructor(private val localDataSource: WeathersDataSource, private val remoteDataSource: WeathersDataSource) : WeathersDataSource {
    override fun saveCurrentDayForecast(cityName: String, weathers: RealmList<Properties>?) {
        localDataSource.saveCurrentDayForecast(cityName, weathers)
    }

    override fun saveWeather(weather: Weather) {
        localDataSource.saveWeather(weather)
    }

    override fun saveLongtermForecast(weathers: RealmList<Properties>) {
        localDataSource.saveLongtermForecast(weathers)
    }

    override fun getWeatherList(city: String, numberOfDays: String, loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {
        remoteDataSource.getWeatherList(city, numberOfDays, loadWeathersCallback)

    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getWeather(city: String, getWeatherCallback: WeathersDataSource.GetWeatherCallback) {
        remoteDataSource.getWeather(city, getWeatherCallback)
    }


    override fun getCurrentWeather(cityName: String, callback: WeathersDataSource.GetWeatherCallback) {
        localDataSource.getCurrentWeather(cityName, object : WeathersDataSource.GetWeatherCallback{
            override fun onSuccess(weather: Weather) {
                callback.onSuccess(weather)
                getCurrentWeatherFromRemote(cityName, callback)
            }

            override fun onFail() {
                callback.onFail()
                getCurrentWeatherFromRemote(cityName, callback)
            }

        })

    }

    private fun getCurrentWeatherFromRemote(cityName: String, callback: WeathersDataSource.GetWeatherCallback){
        remoteDataSource.getCurrentWeather(cityName, object : WeathersDataSource.GetWeatherCallback {
            override fun onSuccess(weather: Weather) {
                saveWeather(weather)
                callback.onSuccess(weather)
            }

            override fun onFail() {
                callback.onFail()
            }

        })
    }

    override fun getTodayForecast(cityName: String, callback: WeathersDataSource.LoadWeathersCallback) {
        remoteDataSource.getTodayForecast(cityName, object : WeathersDataSource.LoadWeathersCallback {
            override fun onSuccess(weatherList: RealmList<Properties>?) {
                saveCurrentDayForecast(cityName, weatherList)
                callback.onSuccess(weatherList)
            }

            override fun onFail() {

                callback.onFail()
            }

        })
    }

    companion object {

        private var INSTANCE: WeathersRepository? = null

        fun getInstance(localDataSource: WeathersDataSource,
                        remoteDataSource: WeathersDataSource): WeathersRepository {
            if (INSTANCE == null) {
                INSTANCE = WeathersRepository(localDataSource, remoteDataSource)
            }
            return INSTANCE!!
        }
    }
}
