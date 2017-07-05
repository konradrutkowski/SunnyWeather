package com.pjkr.sunnyweather.data.remote


import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.longterm.model.Weather


/**
 * Created by konradrutkowski on 04.07.2017.
 */

object RemoteDataSource : WeathersDataSource {

    override fun getWeatherList(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getWeather(getWeatherCallback: WeathersDataSource.GetWeatherCallback): Weather {
        return Weather()
    }

//    companion object {
//
//        private var INSTANCE: RemoteDataSource? = null
//
//        val instance: RemoteDataSource
//            get() {
//                if (INSTANCE == null) {
//                    INSTANCE = RemoteDataSource()
//                }
//                return INSTANCE!!
//            }
//    }
}
