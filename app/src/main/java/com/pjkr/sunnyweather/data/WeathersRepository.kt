package com.pjkr.sunnyweather.data

import com.pjkr.sunnyweather.longterm.model.Weather

/**
 * Created by konradrutkowski on 04.07.2017.
 */

class WeathersRepository private constructor(private val localDataSource: WeathersDataSource, private val remoteDataSource: WeathersDataSource) : WeathersDataSource {

    override fun getWeatherList(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getWeather(getWeatherCallback: WeathersDataSource.GetWeatherCallback): Weather {
        return Weather()
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