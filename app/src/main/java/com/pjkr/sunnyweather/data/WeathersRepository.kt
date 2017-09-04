package com.pjkr.sunnyweather.data

/**
 * Created by konradrutkowski on 04.07.2017.
 */

class WeathersRepository constructor(private val localDataSource: WeathersDataSource, private val remoteDataSource: WeathersDataSource) : WeathersDataSource {

    override fun getWeatherList(city: String, numberOfDays: String,  loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {
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
       remoteDataSource.getCurrentWeather(cityName, callback)
    }

    override fun getTodayForecast(cityName: String, callback: WeathersDataSource.LoadWeathersCallback) {
        remoteDataSource.getTodayForecast(cityName, callback)
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
