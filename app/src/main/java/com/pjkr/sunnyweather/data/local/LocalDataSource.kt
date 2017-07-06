package com.pjkr.sunnyweather.data.local


import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.longterm.model.Weather

/**
 * Created by konradrutkowski on 04.07.2017.
 */

object LocalDataSource : WeathersDataSource {

    override fun getWeatherList(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {}

    override fun getWeather(getWeatherCallback: WeathersDataSource.GetWeatherCallback) {
    }

//    companion object {
//
//        private var INSTANCE: LocalDataSource? = null
//
//        val instance: LocalDataSource
//            get() {
//                if (INSTANCE == null) {
//                    INSTANCE = LocalDataSource()
//                }
//                return INSTANCE!!
//            }
//    }
}
