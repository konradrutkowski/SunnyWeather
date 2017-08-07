package com.pjkr.sunnyweather.data

/**
 * Created by konradrutkowski on 04.07.2017.
 */

class WeathersRepository constructor(private val localDataSource: WeathersDataSource, private val remoteDataSource: WeathersDataSource) : WeathersDataSource {

    override fun getWeatherList(city: String, loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getWeather(city: String, getWeatherCallback: WeathersDataSource.GetWeatherCallback) {
        remoteDataSource.getWeather(city, getWeatherCallback)
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
